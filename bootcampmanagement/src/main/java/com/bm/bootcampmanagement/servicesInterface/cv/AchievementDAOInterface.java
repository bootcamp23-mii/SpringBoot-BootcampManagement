/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Achievement;
import com.bm.bootcampmanagement.servicesInterface.bm.*;
import com.bm.bootcampmanagement.entities.Score;

/**
 *
 * @author FES
 */
public interface AchievementDAOInterface {
    Iterable<Achievement> findAll();
    Achievement findById(String id);
    Achievement save(Achievement achievement);
    void delete(String id);
}
