/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Employeelanguage;
import com.bm.bootcampmanagement.repository.cv.EmployeeLanguageRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.EmployeeLanguageDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerydanu
 */
@Service
public class EmployeeLanguageDAO implements EmployeeLanguageDAOInterface {
    
    @Autowired
    EmployeeLanguageRepository er;
    
    @Override
    public Iterable<Employeelanguage> findAll() {
        return er.findAll();
    }

    @Override
    public Employeelanguage save(Employeelanguage employeelanguage) {
        return er.save(employeelanguage);
    }

    @Override
    public void delete(String id) {
        er.deleteById(id);
    }

    @Override
    public Employeelanguage findById(String id) {
        return er.findById(id).get();
    }
    
}
