/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Workexperience;
import com.bm.bootcampmanagement.repository.cv.WorkExperienceRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.WorkExperienceDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerydanu
 */
@Service
public class WorkExperienceDAO implements WorkExperienceDAOInterface {
    
    @Autowired
    WorkExperienceRepository wr;

    @Override
    public Iterable<Workexperience> findAll() {
        return wr.findAll();
    }

    @Override
    public Workexperience save(Workexperience workexperience) {
        return wr.save(workexperience);
    }

    @Override
    public void delete(String id) {
        wr.deleteById(id);
    }

    @Override
    public Workexperience findById(String id) {
        return wr.findById(id).get();
    }
    
}
