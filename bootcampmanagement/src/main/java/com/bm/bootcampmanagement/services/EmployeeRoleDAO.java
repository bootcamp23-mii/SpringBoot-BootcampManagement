/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services;

import com.bm.bootcampmanagement.entities.Employeerole;
import com.bm.bootcampmanagement.repository.cv.EmployeeRoleRepository;
import com.bm.bootcampmanagement.servicesInterface.EmployeeRoleDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerydanu
 */
@Service
public class EmployeeRoleDAO  implements EmployeeRoleDAOInterface {
    
    @Autowired
    EmployeeRoleRepository er;
    
    @Override
    public Iterable<Employeerole> findAll() {
        return er.findAll();
    }

    @Override
    public Employeerole save(Employeerole employeerole) {
        return er.save(employeerole);
    }

    @Override
    public void delete(String id) {
        er.deleteById(id);
    }

    @Override
    public Employeerole findById(String id) {
        return er.findById(id).get();
    }
}
