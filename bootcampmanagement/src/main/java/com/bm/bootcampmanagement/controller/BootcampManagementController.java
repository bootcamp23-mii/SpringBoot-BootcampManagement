/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.*;
import com.bm.bootcampmanagement.services.*;
import com.bm.bootcampmanagement.services.bm.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
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
    
    //participant
    @GetMapping("/bm/participant")
    public String participant(Model model){
        List<Employee> empList = (List<Employee>)daoEmp.findAll();
        List<Batchclass> batchclassList = (List<Batchclass>)daoBC.findAll();
        List<Employee> dataEmployee = new ArrayList<>();
        for (int i=0;i<empList.size();i++) {
            boolean isTrainer=false;
            for (Batchclass batchclass : batchclassList) {
                if (batchclass.getTrainer().getId().equalsIgnoreCase(empList.get(i).getId())) {
                    isTrainer=true;
                }
            }
            if (empList.get(i).getIsdeleted().intValue()==0&&!isTrainer) {
                dataEmployee.add(empList.get(i));
            }
        }
        List<Participant> participantList = (List<Participant>)daoP.findAll();
        List<Participant> dataParticipant = new ArrayList<>();
        for (Participant data : participantList) {
            if (data.getIsdeleted()==0) {
                dataParticipant.add(data);
            }
        }
        model.addAttribute("dataEmployee", dataEmployee);
        model.addAttribute("dataParticipant", dataParticipant);
        model.addAttribute("dataBatchclass", daoBC.findAll());
        return "/bm/participant";
    }
    
    @PostMapping("/bm/saveParticipant")
    public String saveParticipant(@RequestParam("employeeId")String empId,@RequestParam("batchclassId")String batchclassId){
        daoP.save(new Participant(empId, "", new Short("0"), new Batchclass(batchclassId), new Employee(empId)));
        return "redirect:/bm/participant";
    }
    
    @GetMapping("/bm/deleteParticipant/{id}")
    public String deleteParticipant(@PathVariable("id") String id){
        List<Participant> pList = (List<Participant>)daoP.findAll();
        for (Participant data : pList) {
            if (data.getId().equalsIgnoreCase(id)) {
                daoP.save(new Participant(data.getId(), data.getGrade(), new Short("1"), new Batchclass(data.getBatchclass().getId()), new Employee(data.getId())));
            }
        }
        return "redirect:/bm/participant";
    }
    //evaluation
    @GetMapping("/bm/evaluation")
    public String evaluation(Model model){
//        Iterable<Employee> empList=daoEmp.findAll();
        model.addAttribute("dataParticipant", daoP.findAll());
        model.addAttribute("dataEvaluation", daoE.findAll());
        model.addAttribute("dataTopic", daoT.findAll());
        model.addAttribute("dataLesson", daoL.findAll());
        return "/bm/evaluation";
    }
    
    @GetMapping("/bm/addEvaluation")
    public String addEvaluation(){
        return "/bm/evaluation";
    }
    
    //score
    @GetMapping("/bm/score")
    public String score(Model model){
//        Iterable<Employee> empList=daoEmp.findAll();
        model.addAttribute("dataScore", daoS.findAll());
        return "/bm/score";
    }
    
    @GetMapping("/bm/addScore")
    public String addScore(){
        return "/bm/score";
    }
    
    //batchclass
    @GetMapping("/bm/batchclass")
    public String batchclass(Model model){
//        Iterable<Employee> empList=daoEmp.findAll();
        model.addAttribute("dataBatchclass", daoBC.findAll());
        model.addAttribute("dataTrainer", daoEmp.findAll());
        model.addAttribute("dataRoom", daoR.findAll());
        model.addAttribute("dataBatch", daoB.findAll());
        model.addAttribute("dataClasses", daoC.findAll());
        return "/bm/batchclass";
    }
    
    @GetMapping("/bm/addBatchclass")
    public String addBatchclass(){
        return "/bm/batchclass";
    }
    
    //errorbank
    @GetMapping("/bm/errorbank")
    public String errorbank(Model model){
//        Iterable<Employee> empList=daoEmp.findAll();
        model.addAttribute("dataClasses", daoC.findAll());
        model.addAttribute("dataErrorbank", daoEB.findAll());
        return "/bm/errorbank";
    }
    
    @GetMapping("/bm/addErrorbank")
    public String addErrorbank(){
        return "/bm/errorbank";
    }
}
