/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.controller;

import com.bm.bootcampmanagement.entities.Batchclass;
import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.services.BCrypt;
import com.bm.bootcampmanagement.services.MailService;
import com.bm.bootcampmanagement.services.EmployeeDAO;
import com.bm.bootcampmanagement.services.bm.BatchclassDAO;
import javax.servlet.http.HttpServletRequest;
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
//    @Autowired
//    Employeerole
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
    public String checkLogin(@RequestParam("idEmp") String id, @RequestParam("passEmp") String password, HttpServletRequest request) {
        if (daoEmp.findById(id) != null) {
            Employee employee = daoEmp.findById(id);
            if (BCrypt.checkpw(password, employee.getPassword())) {
                request.getSession().setAttribute("login", id);
                
                Iterable<Batchclass> batchclass = daoBC.findAll();
                for (Batchclass data : batchclass) {
                    if (data.getTrainer().equals(id)) {
                        request.getSession().setAttribute("isTrainer", true);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    
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
