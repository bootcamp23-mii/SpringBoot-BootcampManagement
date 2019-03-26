/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Education;
import com.bm.bootcampmanagement.repository.cv.EducationRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.EducationDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lusiana
 */
@Service
public class EducationDAO implements EducationDAOInterface {
    @Autowired
    EducationRepository er;
    
    @Override
    public Iterable<Education> findAll() {
        return er.findAll();
    }

    @Override
    public Education findById(String id) {
        return er.findById(id).get();
    }

    @Override
    public Education save(Education education) {
        return er.save(education);
    }

    @Override
    public void delete(String id) {
        er.deleteById(id);
    }

}
