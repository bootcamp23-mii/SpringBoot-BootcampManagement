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
public interface EvaluationDAOInterface {
    Iterable<Evaluation> findAll();
    Evaluation findById(String id);
    Evaluation save(Evaluation entity);
    void delete(String id);
}
