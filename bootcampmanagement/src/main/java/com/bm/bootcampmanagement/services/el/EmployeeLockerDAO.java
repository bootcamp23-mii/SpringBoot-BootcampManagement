/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Employeelocker;
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
    public Iterable<Employeelocker> findAll() {
        return elr.findAll();
    }

    @Override
    public Employeelocker saveEmployeeLocker(Employeelocker employeelocker) {
        return elr.save(employeelocker);
    }

    @Override
    public void deleteEmployeeLockerById(String id) {
        elr.deleteById(id);
    }
    
}
