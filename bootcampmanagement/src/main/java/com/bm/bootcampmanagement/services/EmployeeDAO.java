/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services;

import com.bm.bootcampmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bm.bootcampmanagement.servicesInterface.EmployeeDAOInterface;
import com.bm.bootcampmanagement.repository.EmployeeRepository;

/**
 *
 * @author FES
 */
@Service
public class EmployeeDAO implements EmployeeDAOInterface{
         
    @Autowired
    EmployeeRepository r;

    @Override
    public Iterable<Employee> findAll() {
        return r.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return r.save(employee);
    }

    @Override
    public void delete(String id) {
        r.deleteById(id);
    }

    @Override
    public Employee findById(String id) {
        return r.findById(id).get();
    }
}
