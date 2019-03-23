/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.bm;

import com.bm.bootcampmanagement.entities.Score;
import com.bm.bootcampmanagement.repository.bm.ScoreRepository;
import com.bm.bootcampmanagement.servicesInterface.bm.ScoreDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FES
 */
@Service
public class ScoreDAO implements ScoreDAOInterface{
     
    @Autowired
    ScoreRepository repository;
    
    @Override
    public Iterable<Score> findAll() {
        return repository.findAll();
    }

    @Override
    public Score save(Score score) {
        return repository.save(score);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
