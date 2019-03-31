/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.*;
import com.bm.bootcampmanagement.services.*;
import com.bm.bootcampmanagement.services.bm.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    private SimpleDateFormat dateFormatOut = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/bm/*")
    public String error() {
        return "redirect:/error";
    }

    @GetMapping("/bm/bm")
    public String bm() {
        return "/bm/bm";
    }

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
            daoE.save(new Evaluation(tempId, new Short(isDaily), dateFormatOut.parse(evaluationDate), "", new Short("0"), new Lesson(idLesson), new Topic(idTopic), new Employee(idEmployee)));
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
    public String score(Model model, HttpServletRequest request) {
        List<Score> scoreList = (List<Score>) daoS.findAll();
        List<Score> dataScore = new ArrayList<>();
        for (int i = 0; i < scoreList.size(); i++) {
            if (scoreList.get(i).getEvaluation().getId().equalsIgnoreCase(request.getSession().getAttribute("idScore").toString()) && scoreList.get(i).getIsdeleted().intValue() == 0) {
                dataScore.add(scoreList.get(i));
            }
        }
        model.addAttribute("dataScore", dataScore);
        model.addAttribute("dataAspect", daoA.findAll());
        return "/bm/score";
    }

    @GetMapping("/bm/getscore/{id}")
    public String getscore(@PathVariable("id") String id, HttpServletRequest request) {
        request.getSession().setAttribute("idScore", id);
        return "redirect:/bm/score";
    }

    @PostMapping("/bm/saveScore")
    public String saveScore(@RequestParam("scoreId") String id, @RequestParam("aspectId") String aspect, @RequestParam("aspectRating") String rating, HttpServletRequest request) {
        String tempId = "-";
        if (!id.equalsIgnoreCase("")) {
            tempId = id;
        }
        List<Score> scoreList = (List<Score>) daoS.findAll();
        List<Score> dataScore = new ArrayList<>();
        for (int i = 0; i < scoreList.size(); i++) {
            if (scoreList.get(i).getEvaluation().getId().equalsIgnoreCase(request.getSession().getAttribute("idScore").toString()) && scoreList.get(i).getIsdeleted().intValue() == 0) {
                dataScore.add(scoreList.get(i));
            }
        }
        for (Score data : dataScore) {
            if (data.getAspect().getId().equalsIgnoreCase(aspect) && data.getEvaluation().getId().equalsIgnoreCase(request.getSession().getAttribute("idScore").toString())) {
                tempId = data.getId();
            }
        }
        daoS.save(new Score(tempId, new Double(rating), new Short("0"), new Aspect(aspect), new Evaluation(request.getSession().getAttribute("idScore").toString())));
        return "redirect:/bm/score";
    }

    @GetMapping("/bm/deleteScore/{id}")
    public String saveScore(@PathVariable("id") String id) {
        List<Score> list = (List<Score>) daoS.findAll();
        for (Score data : list) {
            if (data.getId().equalsIgnoreCase(id)) {
                daoS.save(new Score(data.getId(), data.getRating(), new Short("1"), new Aspect(data.getAspect().getId()), new Evaluation(data.getEvaluation().getId())));
            }
        }
        return "redirect:/bm/score";
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
        List<Errorbank> errorList = (List<Errorbank>) daoEB.findAll();
        List<Errorbank> dataErrorbank = new ArrayList<>();
        for (Errorbank data : errorList) {
            if (data.getIsdeleted().intValue() == 0) {
                dataErrorbank.add(data);
            }
        }
        model.addAttribute("dataErrorbank", dataErrorbank);
        model.addAttribute("dataClasses", daoC.findAll());
        return "/bm/errorbank";
    }

    @PostMapping("/bm/saveErrorbank")
    public String saveErrorbank(@RequestParam("errorbankId") String id, @RequestParam("errorbankSubmiter") String employeeId, @RequestParam("errorbankClassesId") String classesId, @RequestParam("errorbankSubmitdate") String SubmitDate, @RequestParam("errorbankDescription") String description, @RequestParam("errorbankSolution") String solution, HttpServletRequest request) {
        try {
            String tempId = "-", tempEmp = request.getSession().getAttribute("login").toString();
            if (!id.equalsIgnoreCase("")) {
                tempId = id;
                if (!tempEmp.equalsIgnoreCase(employeeId)) {
                    return "redirect:/bm/errorbank";
                }
            }
            if (!employeeId.equalsIgnoreCase("")) {
                tempEmp = employeeId;
            }
            daoEB.save(new Errorbank(tempId, dateFormatOut.parse(SubmitDate), description, solution, new Short("0"), new Classes(classesId), new Employee(tempEmp)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/bm/errorbank";
    }

    @GetMapping("/bm/deleteErrorbank/{id}")
    public String saveErrorbank(@PathVariable("id") String id, HttpServletRequest request) {
        List<Errorbank> list = (List<Errorbank>) daoEB.findAll();
        for (Errorbank data : list) {
            if (data.getId().equalsIgnoreCase(id)) {
                if (!data.getEmployee().getId().equalsIgnoreCase(request.getSession().getAttribute("login").toString())) {
                    return "redirect:/bm/errorbank";
                }
                daoEB.save(new Errorbank(data.getId(), data.getSubmitdate(), data.getDescription(), data.getSolution(), new Short("1"), new Classes(data.getClasses().getId()), new Employee(data.getEmployee().getId())));
            }
        }
        return "redirect:/bm/errorbank";
    }

    //report
    @GetMapping("/bm/report")
    public String report(Model model, HttpServletRequest request) {
        List<Participant> participantList = (List<Participant>) daoP.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        for (Participant data : participantList) {
            if (data.getBatchclass().getTrainer().getId().equalsIgnoreCase(request.getSession().getAttribute("login").toString())) {
                dataParticipant.add(data);
            }
        }
        model.addAttribute("dataParticipant", dataParticipant);
        return "/bm/report";
    }

    @PostMapping("/bm/generatereport")
    public String generateReport(HttpServletRequest request, @RequestParam("participantId") String id) {
        List<Evaluation> evaluationList = (List<Evaluation>) daoE.findAll();
        double isDailyScore = 0, isWeeklyScore = 0;
        int count = 0;
        for (Evaluation evaluation : evaluationList) {
            if (evaluation.getIsdaily().intValue() == 1 && evaluation.getParticipant().getId().equalsIgnoreCase(id)) {
                for (Score score : evaluation.getScoreList()) {
                    isDailyScore += score.getRating();
                    count++;
                }
            }
        }
        isDailyScore = (isDailyScore / count) * 0.3;
        count = 0;
        for (Evaluation evaluation : evaluationList) {
            if (evaluation.getIsdaily().intValue() == 0 && evaluation.getParticipant().getId().equalsIgnoreCase(id)) {
                for (Score score : evaluation.getScoreList()) {
                    isWeeklyScore += score.getRating();
                    count++;
                }
            }
        }
        isWeeklyScore = (isWeeklyScore / count) * 0.7;
        GenerateGrade(id, isDailyScore + isWeeklyScore);
        request.getSession().setAttribute("isdailyscore", isDailyScore);
        request.getSession().setAttribute("isweeklyscore", isWeeklyScore);
        request.getSession().setAttribute("participantid", id);
        return "redirect:/bm/reportpage";
    }

//    @RequestMapping(value = "/lihatFile", method = RequestMethod.GET,
//            produces = MediaType.IMAGE_JPEG_VALUE)
//    public ResponseEntity<byte[]> getImage(HttpServletRequest request) throws IOException {
//        Employee employee = DBFileStorageService.getFile(request.getSession().getAttribute("login").toString());
//
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(employee.getPhoto());
//    }

    public String GenerateGrade(String id, double finalScore) {
        String grade = "";
        if (finalScore >= 75) {
            grade = "A";
        } else {
            grade = "B";
        }
        Participant data = daoP.findById(id);
        daoP.save(new Participant(data.getId(), grade, new Short("0"), new Batchclass(data.getBatchclass().getId()), new Employee(data.getId())));
        return grade;
    }

    @GetMapping("/bm/reportpage")
    public String reportpage(Model model, HttpServletRequest request) {
        Participant participant = daoP.findById(request.getSession().getAttribute("participantid").toString());
        model.addAttribute("participant", participant);
        model.addAttribute("isdailyscore", request.getSession().getAttribute("isdailyscore"));
        model.addAttribute("isweeklyscore", request.getSession().getAttribute("isweeklyscore"));
        return "/bm/reportpage";
    }

}
