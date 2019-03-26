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
public interface TopicDAOInterface {
    Iterable<Topic> findAll();
    Topic findById(String id);
    Topic save(Topic entity);
    void delete(String id);
}
