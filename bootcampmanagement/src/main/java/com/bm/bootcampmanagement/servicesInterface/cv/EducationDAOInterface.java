/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Education;

/**
 *
 * @author Lusiana
 */
public interface EducationDAOInterface {

    Iterable<Education> findAll();

    Education findById(String id);

    Education save(Education education);

    void delete(String id);
}
