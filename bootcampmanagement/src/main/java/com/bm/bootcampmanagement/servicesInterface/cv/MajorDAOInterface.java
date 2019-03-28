/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Major;



/**
 *
 * @author Lusiana
 */
public interface MajorDAOInterface {
    Iterable<Major> findAll();
    Major findById(String id);
    Major save(Major major);
    void delete(String id);
}
