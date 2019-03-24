/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.Accesscard;


/**
 *
 * @author Firsta
 */

public interface AccessCardDAOInterface {
    Iterable<Accesscard> findAll();
    Accesscard saveAccessCard(Accesscard accesscard);
    void deleteAccessCardById(String id);
}
