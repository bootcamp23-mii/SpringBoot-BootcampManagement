/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Accesscard;
import com.bm.bootcampmanagement.entities.Locker;
import com.bm.bootcampmanagement.repository.el.AccessCardRepository;
import com.bm.bootcampmanagement.servicesInterface.el.AccessCardDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class AccessCardDAO implements AccessCardDAOInterface{

    @Autowired
    AccessCardRepository acr;

    @Override
    public Iterable<Accesscard> findAll() {
       return acr.findAll();
    }

    @Override
    public Accesscard saveAccessCard(Accesscard accesscard) {
        return acr.save(accesscard);
    }

    @Override
    public void deleteAccessCardById(String id) {
        acr.deleteById(id);
    }
 
}
