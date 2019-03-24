/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.bm;

import com.bm.bootcampmanagement.entities.AccessCard;
import com.bm.bootcampmanagement.entities.Locker;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public interface AccessCardDAOInterface {
    Iterable<AccessCard> findAll();
    AccessCard saveAccessCard(AccessCard accessCard);
    void deleteAccessCardById(String id);
}
