/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.Employeeaccess;


/**
 *
 * @author Firsta
 */

public interface EmployeeAccessDAOInterface {
    Iterable<Employeeaccess> findAll();
    Employeeaccess saveEmployeeAccess(Employeeaccess access);
    void deleteEmployeeAccessById(String id);
}
