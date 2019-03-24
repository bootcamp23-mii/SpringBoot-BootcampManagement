/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Employeeskill;
import com.bm.bootcampmanagement.repository.cv.EmployeeSkillRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.EmployeeSkillDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerydanu
 */
@Service
public class EmployeeSkillDAO implements EmployeeSkillDAOInterface{
    
    @Autowired
    EmployeeSkillRepository er;

    @Override
    public Iterable<Employeeskill> findAll() {
        return er.findAll();
    }

    @Override
    public Employeeskill save(Employeeskill employeeskill) {
        return er.save(employeeskill);
    }

    @Override
    public void delete(String id) {
        er.deleteById(id);
    }

    @Override
    public Employeeskill findById(String id) {
        return er.findById(id).get();
    }
    
}
