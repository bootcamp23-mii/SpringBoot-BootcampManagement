/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.bm;

import com.bm.bootcampmanagement.entities.Score;

/**
 *
 * @author FES
 */
public interface ScoreDAOInterface {
    Iterable<Score> findAll();
    Score findById(String id);
    Score save(Score entity);
    void delete(String id);
}
