/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Achievement;
import com.bm.bootcampmanagement.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bm.bootcampmanagement.repository.cv.AchievementRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.AchievementDAOInterface;

/**
 *
 * @author FES
 */
@Service
public class AchievementDAO implements AchievementDAOInterface{
         
    @Autowired
    AchievementRepository ar;

    @Override
    public Iterable<Achievement> findAll() {
        return ar.findAll();
    }

    @Override
    public Achievement save(Achievement achievement) {
        return ar.save(achievement);
    }

    @Override
    public void delete(String id) {
        ar.deleteById(id);
    }

    @Override
    public Achievement findById(String id) {
        return ar.findById(id).get();
    }

  
}
