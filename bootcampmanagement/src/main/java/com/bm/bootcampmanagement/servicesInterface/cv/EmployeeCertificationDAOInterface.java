/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Achievement;
import com.bm.bootcampmanagement.entities.EmployeeCertification;
import com.bm.bootcampmanagement.servicesInterface.bm.*;
import com.bm.bootcampmanagement.entities.Score;

/**
 *
 * @author FES
 */
public interface EmployeeCertificationDAOInterface {
    Iterable<EmployeeCertification> findAll();
    EmployeeCertification findById(String id);
    EmployeeCertification save(EmployeeCertification employeeCertification);
    void delete(String id);
}
