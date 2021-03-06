/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.bm;

import com.bm.bootcampmanagement.entities.*;
import com.bm.bootcampmanagement.repository.bm.ScoreRepository;
import com.bm.bootcampmanagement.servicesInterface.bm.ScoreDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FES
 */
@Service
public class ScoreDAO implements ScoreDAOInterface {

    @Autowired
    ScoreRepository r;

    @Override
    public Iterable<Score> findAll() {
        return r.findAll();
    }

    @Override
    public Score save(Score score) {
        return r.save(score);
    }

    @Override
    public Score findById(String id) {
        return r.findById(id).get();
    }

    @Override
    public void delete(String id) {
        r.deleteById(id);
    }
}
