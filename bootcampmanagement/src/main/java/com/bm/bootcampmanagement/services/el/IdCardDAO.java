/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;
import com.bm.bootcampmanagement.entities.Idcard;
import com.bm.bootcampmanagement.repository.el.IdCardRepository;
import com.bm.bootcampmanagement.servicesInterface.el.IdCardDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class IdCardDAO implements IdCardDAOInterface{
    
    @Autowired
    IdCardRepository icr;

    @Override
    public Iterable<Idcard> findAll() {
        return icr.findAll();
    }

    @Override
    public Idcard saveIdCard(Idcard idcard) {
        return icr.save(idcard);
    }

    @Override
    public void deleteIdCardById(String id) {
        icr.deleteById(id);
    }
    
}
