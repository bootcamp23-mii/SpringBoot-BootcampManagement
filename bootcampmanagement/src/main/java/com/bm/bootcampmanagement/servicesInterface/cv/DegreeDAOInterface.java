/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Degree;

/**
 *
 * @author Lusiana
 */
public interface DegreeDAOInterface {

    Iterable<Degree> findAll();

    Degree findById(String id);

    Degree save(Degree degree);

    void delete(String id);
}
