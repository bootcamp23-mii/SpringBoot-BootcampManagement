/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.bm;

import com.bm.bootcampmanagement.entities.EmployeeLocker;


/**
 *
 * @author Firsta
 */

public interface EmployeeLockerDAOInterface {
    Iterable<EmployeeLocker> findAll();
    EmployeeLocker saveEmployeeLocker(EmployeeLocker employeeLocker);
    void deleteEmployeeLockerById(String id);
}
