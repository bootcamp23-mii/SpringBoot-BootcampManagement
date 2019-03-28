/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Degree;
import com.bm.bootcampmanagement.repository.cv.DegreeRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.DegreeDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lusiana
 */
@Service
public class DegreeDAO implements DegreeDAOInterface{

    @Autowired
    DegreeRepository dr;

    @Override
    public Iterable<Degree> findAll() {
        return dr.findAll();
    }

    @Override
    public Degree save(Degree degree) {
        return dr.save(degree);
    }

    @Override
    public void delete(String id) {
        dr.deleteById(id);
    }

    @Override
    public Degree findById(String id) {
        return dr.findById(id).get();
    }

    
}
