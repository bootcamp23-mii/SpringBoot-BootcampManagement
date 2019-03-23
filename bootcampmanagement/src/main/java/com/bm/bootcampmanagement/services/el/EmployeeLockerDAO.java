/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.EmployeeLocker;
import com.bm.bootcampmanagement.repository.el.EmployeeLockerRepository;
import com.bm.bootcampmanagement.servicesInterface.el.EmployeeLockerDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class EmployeeLockerDAO implements EmployeeLockerDAOInterface{
    
    @Autowired
    EmployeeLockerRepository elr;
    
    @Override
    public Iterable<EmployeeLocker> findAll() {
        return elr.findAll();
    }

    @Override
    public EmployeeLocker saveEmployeeLocker(EmployeeLocker employeeLocker) {
        return elr.save(employeeLocker);
    }

    @Override
    public void deleteEmployeeLockerById(String id) {
        elr.deleteById(id);
    }
    
}
