/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.bm;

import com.bm.bootcampmanagement.entities.EmployeeAccess;
import com.bm.bootcampmanagement.repository.bm.EmployeeAccessRepository;
import com.bm.bootcampmanagement.servicesInterface.bm.EmployeeAccessDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class EmployeeAccessDAO implements EmployeeAccessDAOInterface{
    
    @Autowired
    EmployeeAccessRepository accessRepository;
    
    @Override
    public Iterable<EmployeeAccess> findAll() {
        return accessRepository.findAll();
    }

    @Override
    public EmployeeAccess saveEmployeeAccess(EmployeeAccess access) {
        return accessRepository.save(access);
    }

    @Override
    public void deleteEmployeeAccessById(String id) {
        accessRepository.deleteById(id);
    }
    
}
