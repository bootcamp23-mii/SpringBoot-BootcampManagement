/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.services.*;
import com.bm.bootcampmanagement.entities.Employeecertification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bm.bootcampmanagement.repository.cv.EmployeecertificationRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.EmployeecertificationDAOInterface;

/**
 *
 * @author FES
 */
@Service
public class EmployeeCertificationDAO implements EmployeecertificationDAOInterface{
         
    @Autowired
    EmployeecertificationRepository ar;

    @Override
    public Iterable<Employeecertification> findAll() {
        return ar.findAll();
    }

    @Override
    public Employeecertification save(Employeecertification employeecertification) {
        return ar.save(employeecertification);
    }

    @Override
    public void delete(String id) {
        ar.deleteById(id);
    }

    @Override
    public Employeecertification findById(String id) {
        return ar.findById(id).get();
    }

  
}
