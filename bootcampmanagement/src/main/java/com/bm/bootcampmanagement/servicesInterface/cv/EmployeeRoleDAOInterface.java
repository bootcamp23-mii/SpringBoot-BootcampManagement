/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Employeerole;

/**
 *
 * @author gerydanu
 */
public interface EmployeeRoleDAOInterface {
    
    Iterable<Employeerole> findAll();
    Employeerole findById(String id);
    Employeerole save(Employeerole employeerole);
    void delete(String id);
    
}
