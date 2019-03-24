/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Employeeaccess;
import com.bm.bootcampmanagement.repository.el.EmployeeAccessRepository;
import com.bm.bootcampmanagement.servicesInterface.el.EmployeeAccessDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class EmployeeAccessDAO implements EmployeeAccessDAOInterface{
    
    @Autowired
    EmployeeAccessRepository ear;

    @Override
    public Iterable<Employeeaccess> findAll() {
       return ear.findAll();
    }

    @Override
    public Employeeaccess saveEmployeeAccess(Employeeaccess access) {
        return ear.save(access);
    }

    @Override
    public void deleteEmployeeAccessById(String id) {
        ear.deleteById(id);
    }
   
    
}
