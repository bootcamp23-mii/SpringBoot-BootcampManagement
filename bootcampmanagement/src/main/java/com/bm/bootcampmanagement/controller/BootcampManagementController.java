/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.*;
import com.bm.bootcampmanagement.services.*;
import com.bm.bootcampmanagement.services.bm.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author FES
 */
@Controller
public class BootcampManagementController {

    @Autowired
    EmployeeDAO daoEmp;
    @Autowired
    ParticipantDAO daoP;
    @Autowired
    BatchclassDAO daoBC;
    @Autowired
    EvaluationDAO daoE;
    @Autowired
    LessonDAO daoL;
    @Autowired
    AspectDAO daoA;
    @Autowired
    TopicDAO daoT;
    @Autowired
    RoomDAO daoR;
    @Autowired
    BatchDAO daoB;
    @Autowired
    ClassesDAO daoC;
    @Autowired
    ScoreDAO daoS;
    @Autowired
    ErrorbankDAO daoEB;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //participant
    @GetMapping("/bm/participant")
    public String participant(Model model) {
        List<Employee> empList = (List<Employee>) daoEmp.findAll();
        List<Batchclass> batchclassList = (List<Batchclass>) daoBC.findAll();
        List<Employee> dataEmployee = new ArrayList<>();
        for (int i = 0; i < empList.size(); i++) {
            boolean isTrainer = false;
            for (Batchclass batchclass : batchclassList) {
                if (batchclass.getTrainer().getId().equalsIgnoreCase(empList.get(i).getId())) {
                    isTrainer = true;
                }
            }
            if (empList.get(i).getIsdeleted().intValue() == 0 && !isTrainer) {
                dataEmployee.add(empList.get(i));
            }
        }
        List<Participant> participantList = (List<Participant>) daoP.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        for (Participant data : participantList) {
            if (data.getIsdeleted() == 0) {
                dataParticipant.add(data);
            }
        }
        model.addAttribute("dataEmployee", dataEmployee);
        model.addAttribute("dataParticipant", dataParticipant);
        model.addAttribute("dataBatchclass", daoBC.findAll());
        return "/bm/participant";
    }

    @PostMapping("/bm/saveParticipant")
    public String saveParticipant(@RequestParam("employeeId") String empId, @RequestParam("batchclassId") String batchclassId) {
        daoP.save(new Participant(empId, "", new Short("0"), new Batchclass(batchclassId), new Employee(empId)));
        return "redirect:/bm/participant";
    }

    @GetMapping("/bm/deleteParticipant/{id}")
    public String deleteParticipant(@PathVariable("id") String id) {
        List<Participant> list = (List<Participant>) daoP.findAll();
        for (Participant data : list) {
            if (data.getId().equalsIgnoreCase(id)) {
                daoP.save(new Participant(data.getId(), data.getGrade(), new Short("1"), new Batchclass(data.getBatchclass().getId()), new Employee(data.getId())));
            }
        }
        return "redirect:/bm/participant";
    }

    //evaluation
    @GetMapping("/bm/evaluation")
    public String evaluation(Model model, HttpServletRequest request) {
        String trainer = request.getSession().getAttribute("login").toString();
        List<Participant> participantList = (List<Participant>) daoP.findAll();
        List<Evaluation> evaluationList = (List<Evaluation>) daoE.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        List<Evaluation> dataEvaluation = new ArrayList<>();
        for (int i = 0; i < participantList.size(); i++) {
            if (participantList.get(i).getIsdeleted().intValue() == 0 && participantList.get(i).getBatchclass().getTrainer().getId().equalsIgnoreCase(trainer)) {
                dataParticipant.add(participantList.get(i));
            }
        }
        for (int i = 0; i < evaluationList.size(); i++) {
            if (evaluationList.get(i).getIsdeleted().intValue() == 0 && evaluationList.get(i).getParticipant().getParticipant().getBatchclass().getTrainer().getId().equalsIgnoreCase(trainer)) {
                dataEvaluation.add(evaluationList.get(i));
            }
        }

        model.addAttribute("dataParticipant", dataParticipant);
        model.addAttribute("dataEvaluation", dataEvaluation);
        model.addAttribute("dataTopic", daoT.findAll());
        model.addAttribute("dataLesson", daoL.findAll());
        return "/bm/evaluation";
    }

    @PostMapping("/bm/saveEvaluation")
    public String saveEvaluation(@RequestParam("idEvaluation") String id, @RequestParam("idEmployee") String idEmployee, @RequestParam("evaluationDate") String evaluationDate, @RequestParam("idlesson") String idLesson, @RequestParam("idTopic") String idTopic, @RequestParam("isDaily") String isDaily) {
        try {
            String tempId = "-";
        if (!id.equalsIgnoreCase("")) {
            tempId = id;
        }
            daoE.save(new Evaluation(tempId, new Short(isDaily), dateFormat.parse(evaluationDate), "", new Short("0"), new Lesson(idLesson), new Topic(idTopic), new Employee(idEmployee)));
        } catch (Exception ex) {
            Logger.getLogger(BootcampManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/bm/evaluation";
    }

    @GetMapping("/bm/deleteEvaluation/{id}")
    public String deleteEvaluation(@PathVariable("id") String id) {
        try {
            List<Evaluation> list = (List<Evaluation>) daoE.findAll();
            for (Evaluation data : list) {
                if (data.getId().equalsIgnoreCase(id)) {
                    daoE.save(new Evaluation(data.getId(), new Short(data.getIsdaily().toString()), data.getEvaluationdate(), data.getNote(), new Short("1"), new Lesson(data.getLesson().getId()), new Topic(data.getTopic().getId()), new Employee(data.getParticipant().getId())));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BootcampManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/bm/evaluation";
    }

    //score
    @GetMapping("/bm/score")
    public String score(Model model) {
//        Iterable<Employee> empList=daoEmp.findAll();
        model.addAttribute("dataScore", daoS.findAll());
        return "/bm/score";
    }

    @GetMapping("/bm/addScore")
    public String addScore() {
        return "/bm/score";
    }

    //batchclass
    @GetMapping("/bm/batchclass")
    public String batchclass(Model model) {
        List<Employee> empList = (List<Employee>) daoEmp.findAll();
        List<Batchclass> batchclassList = (List<Batchclass>) daoBC.findAll();
        List<Employee> dataTrainer = new ArrayList<>();
        for (int i = 0; i < empList.size(); i++) {
            boolean isTrainer = false;
            for (Batchclass batchclass : batchclassList) {
                if (batchclass.getTrainer().getId().equalsIgnoreCase(empList.get(i).getId())) {
                    isTrainer = true;
                }
            }
            if (empList.get(i).getIsdeleted().intValue() == 0 && isTrainer) {
                dataTrainer.add(empList.get(i));
            }
        }
        List<Batchclass> dataBatchclass = new ArrayList<>();
        for (Batchclass data : batchclassList) {
            if (data.getIsdeleted() == 0) {
                dataBatchclass.add(data);
            }
        }
        model.addAttribute("dataBatchclass", dataBatchclass);
        model.addAttribute("dataTrainer", dataTrainer);
        model.addAttribute("dataRoom", daoR.findAll());
        model.addAttribute("dataBatch", daoB.findAll());
        model.addAttribute("dataClasses", daoC.findAll());
        return "/bm/batchclass";
    }

    @PostMapping("/bm/saveBatchclass")
    public String saveBatchclass(@RequestParam("idBatchclass") String id, @RequestParam("idTrainer") String idTrainer, @RequestParam("idBatch") String idBatch, @RequestParam("idClasses") String idClasses, @RequestParam("idRoom") String idRoom) {
        String tempId = "-";
        if (!id.equalsIgnoreCase("")) {
            tempId = id;
        }
        daoBC.save(new Batchclass(tempId, new Short("0"), new Batch(idBatch), new Room(idRoom), new Classes(idClasses), new Employee(idTrainer)));
        return "redirect:/bm/batchclass";
    }

    @GetMapping("/bm/deleteBatchclass/{id}")
    public String deleteBatchclass(@PathVariable("id") String id) {
        List<Batchclass> list = (List<Batchclass>) daoBC.findAll();
        for (Batchclass data : list) {
            if (data.getId().equalsIgnoreCase(id)) {
                daoBC.save(new Batchclass(data.getId(), new Short("1"), new Batch(data.getBatch().getId()), new Room(data.getRoom().getId()), new Classes(data.getClasses().getId()), new Employee(data.getTrainer().getId())));
            }
        }
        return "redirect:/bm/batchclass";
    }

    //errorbank
    @GetMapping("/bm/errorbank")
    public String errorbank(Model model) {
//        Iterable<Employee> empList=daoEmp.findAll();
        model.addAttribute("dataClasses", daoC.findAll());
        model.addAttribute("dataErrorbank", daoEB.findAll());
        return "/bm/errorbank";
    }

    @GetMapping("/bm/addErrorbank")
    public String addErrorbank() {
        return "/bm/errorbank";
    }
}
