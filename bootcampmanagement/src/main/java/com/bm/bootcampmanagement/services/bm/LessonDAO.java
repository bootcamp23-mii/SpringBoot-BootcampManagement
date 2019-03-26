/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.bm;

import com.bm.bootcampmanagement.entities.*;
import com.bm.bootcampmanagement.repository.bm.*;
import com.bm.bootcampmanagement.servicesInterface.bm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FES
 */
@Service
public class LessonDAO implements LessonDAOInterface {

    @Autowired
    LessonRepository r;

    @Override
    public Iterable<Lesson> findAll() {
        return r.findAll();
    }

    @Override
    public Lesson save(Lesson entity) {
        return r.save(entity);
    }

    @Override
    public Lesson findById(String id) {
        return r.findById(id).get();
    }

    @Override
    public void delete(String id) {
        r.deleteById(id);
    }
}
