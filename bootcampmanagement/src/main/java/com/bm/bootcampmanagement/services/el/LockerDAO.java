/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Locker;
import com.bm.bootcampmanagement.repository.el.LockerRepository;
import com.bm.bootcampmanagement.servicesInterface.el.LockerDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class LockerDAO implements LockerDAOInterface{
    
    @Autowired
    LockerRepository lockerRepository;
    
    @Override
    public Iterable<Locker> findAll() {
        return lockerRepository.findAll();
    }

    @Override
    public Locker saveLocker(Locker locker) {
        return lockerRepository.save(locker);
    }

    @Override
    public void deleteLockerById(String id) {
       lockerRepository.deleteById(id);
    }
    
}
