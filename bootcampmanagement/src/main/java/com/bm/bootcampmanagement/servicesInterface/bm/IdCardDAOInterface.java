/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.bm;

import com.bm.bootcampmanagement.entities.IdCard;

/**
 *
 * @author Firsta
 */
public interface IdCardDAOInterface {
    Iterable<IdCard> findAll();
    IdCard saveIdCard (IdCard idcard);
    void deleteIdCardById(String id);
}
