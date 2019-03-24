/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Educationhistory;
import com.bm.bootcampmanagement.repository.cv.EducationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bm.bootcampmanagement.servicesInterface.cv.EducationHistoryDAOInterface;

/**
 *
 * @author FES
 */
@Service
public class EducationHistoryDAO implements EducationHistoryDAOInterface{
         
    @Autowired
    EducationHistoryRepository er;

    @Override
    public Iterable<Educationhistory> findAll() {
        return er.findAll();
    }

    @Override
    public Educationhistory save(Educationhistory educationhistory) {
        return er.save(educationhistory);
    }

    @Override
    public void delete(String id) {
        er.deleteById(id);
    }

    @Override
    public Educationhistory findById(String id) {
        return er.findById(id).get();
    }

  
}
