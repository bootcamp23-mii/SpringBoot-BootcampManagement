/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.Idcard;


/**
 *
 * @author Firsta
 */
public interface IdCardDAOInterface {
    Iterable<Idcard> findAll();
    Idcard saveIdCard (Idcard idcard);
    void deleteIdCardById(String id);
}
