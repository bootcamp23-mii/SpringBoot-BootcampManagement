/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.bm;

import com.bm.bootcampmanagement.entities.*;

/**
 *
 * @author FES
 */
public interface LessonDAOInterface {
    Iterable<Lesson> findAll();
    Lesson findById(String id);
    Lesson save(Lesson entity);
    void delete(String id);
}
