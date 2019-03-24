/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.Employeelocker;


/**
 *
 * @author Firsta
 */

public interface EmployeeLockerDAOInterface {
    Iterable<Employeelocker> findAll();
    Employeelocker saveEmployeeLocker(Employeelocker employeelocker);
    void deleteEmployeeLockerById(String id);
}
