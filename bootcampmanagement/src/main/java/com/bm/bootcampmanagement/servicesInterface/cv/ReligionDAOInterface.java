/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.*;

/**
 *
 * @author FES
 */
public interface ReligionDAOInterface {
    Iterable<Religion> findAll();
    Religion findById(String id);
    Religion save(Religion entity);
    void delete(String id);
}
