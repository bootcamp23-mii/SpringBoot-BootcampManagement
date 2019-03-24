/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.services.*;
import com.bm.bootcampmanagement.entities.EmployeeCertification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bm.bootcampmanagement.repository.cv.EmployeeCertificationRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.EmployeeCertificationDAOInterface;

/**
 *
 * @author FES
 */
@Service
public class EmployeeCertificationDAO implements EmployeeCertificationDAOInterface{
         
    @Autowired
    EmployeeCertificationRepository ar;

    @Override
    public Iterable<EmployeeCertification> findAll() {
        return ar.findAll();
    }

    @Override
    public EmployeeCertification save(EmployeeCertification employeeCertification) {
        return ar.save(employeeCertification);
    }

    @Override
    public void delete(String id) {
        ar.deleteById(id);
    }

    @Override
    public EmployeeCertification findById(String id) {
        return ar.findById(id).get();
    }

  
}
