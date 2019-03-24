/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Educationhistory;
import com.bm.bootcampmanagement.servicesInterface.bm.*;
import com.bm.bootcampmanagement.entities.Score;

/**
 *
 * @author FES
 */
public interface EducationHistoryDAOInterface {
    Iterable<Educationhistory> findAll();
    Educationhistory findById(String id);
    Educationhistory save(Educationhistory educationhistory);
    void delete(String id);
}
