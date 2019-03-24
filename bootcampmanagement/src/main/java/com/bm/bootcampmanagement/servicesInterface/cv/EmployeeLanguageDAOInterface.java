/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Employeelanguage;

/**
 *
 * @author gerydanu
 */
public interface EmployeeLanguageDAOInterface {
    
    Iterable<Employeelanguage> findAll();
    Employeelanguage findById(String id);
    Employeelanguage save(Employeelanguage employeelanguage);
    void delete(String id);
    
}
