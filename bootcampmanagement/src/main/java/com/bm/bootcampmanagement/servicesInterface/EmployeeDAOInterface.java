/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface;

import com.bm.bootcampmanagement.entities.Employee;

/**
 *
 * @author FES
 */
public interface EmployeeDAOInterface {

    Iterable<Employee> findAll();
    Employee findById(String id);
    Employee save(Employee employee);
    void delete(String id);
    
}
