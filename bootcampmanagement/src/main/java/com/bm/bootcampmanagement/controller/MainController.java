/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Batchclass;
import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.entities.Employeerole;
import com.bm.bootcampmanagement.entities.Participant;
import com.bm.bootcampmanagement.services.BCrypt;
import com.bm.bootcampmanagement.services.MailService;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.bm.BatchclassDAO;
import com.bm.bootcampmanagement.services.bm.ParticipantDAO;
import com.bm.bootcampmanagement.services.cv.EmployeeRoleDAO;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author FES
 */
@Controller
public class MainController {

    @Autowired
    EmployeeDAO daoEmp;
    @Autowired
    BatchclassDAO daoBC;
    @Autowired
    EmployeeRoleDAO daoEmpR;
    @Autowired
    ParticipantDAO daoP;
    @Autowired
    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MailService mailService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
//    @ResponseBody
    public String checkLogin(@RequestParam("idEmp") String id, @RequestParam("passEmp") String password, HttpSession session) {
        if (daoEmp.findById(id) != null) {
            Employee employee = daoEmp.findById(id);
            if (BCrypt.checkpw(password, employee.getPassword())) {
                session.setAttribute("login", id);
                
                Iterable<Batchclass> batchclasses = daoBC.findAll();
                for (Batchclass data : batchclasses) {
                    if (data.getTrainer().equals(id)) {
                        session.setAttribute("isTrainer", id);
                    }
                }
                Iterable<Employeerole> employeeroles = daoEmpR.findAll();
                for (Employeerole data : employeeroles) {
                    if (data.getEmployee().getId().equalsIgnoreCase(id)&&data.getRole().getId().equalsIgnoreCase("CVR0")) {
                        session.setAttribute("isAdmin", id);
                    }
                }
                Iterable<Participant> participants = daoP.findAll();
                for (Participant data : participants) {
                    if (data.getId().equalsIgnoreCase(id)) {
                        session.setAttribute("isParticipant", id);
                    }
                }
                
                return "redirect:/dashboard";
            }
        }
        return "redirect:/index/";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "/dashboard";
    }

}
