/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.bm.BatchclassDAO;
import com.bm.bootcampmanagement.services.bm.ParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    @GetMapping("/bm/participant")
    public String participant(Model model){
//        Iterable<Employee> empList=daoEmp.findAll();
        model.addAttribute("dataEmploye", daoEmp.findAll());
        model.addAttribute("dataBatchclass", daoBC.findAll());
        return "/bm/participant";
    }
    
    @GetMapping("/bm/addParticipant")
    public String addParticipant(){
        return "/bm/participant";
    }
}
