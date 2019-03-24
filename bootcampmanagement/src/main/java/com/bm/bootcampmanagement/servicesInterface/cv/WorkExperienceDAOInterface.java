/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Workexperience;

/**
 *
 * @author gerydanu
 */
public interface WorkExperienceDAOInterface {
    
    Iterable<Workexperience> findAll();
    Workexperience findById(String id);
    Workexperience save(Workexperience workexperience);
    void delete(String id);
    
}
