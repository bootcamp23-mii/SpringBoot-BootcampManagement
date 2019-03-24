/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.bm;

import com.bm.bootcampmanagement.entities.IdCard;
import com.bm.bootcampmanagement.repository.bm.IdCardRepository;
import com.bm.bootcampmanagement.servicesInterface.bm.IdCardDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class IdCardDAO implements IdCardDAOInterface{
    
    @Autowired
    IdCardRepository idCardRepository;

    @Override
    public Iterable<IdCard> findAll() {
        return idCardRepository.findAll();
    }

    @Override
    public IdCard saveIdCard(IdCard idcard) {
        return idCardRepository.save(idcard);
    }

    @Override
    public void deleteIdCardById(String id) {
        idCardRepository.deleteById(id);
    }
    
}
