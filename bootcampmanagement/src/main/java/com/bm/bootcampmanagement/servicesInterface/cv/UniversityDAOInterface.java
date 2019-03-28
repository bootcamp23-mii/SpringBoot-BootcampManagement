/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.University;

/**
 *
 * @author Lusiana
 */
public interface UniversityDAOInterface {
    Iterable<University> findAll();
    University findById(String id);
    University save(University university);
    void delete(String id);
}
