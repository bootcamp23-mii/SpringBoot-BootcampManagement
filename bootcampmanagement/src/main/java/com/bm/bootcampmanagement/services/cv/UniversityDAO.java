/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.University;
import com.bm.bootcampmanagement.repository.cv.UniversityRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.UniversityDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lusiana
 */
@Service
public class UniversityDAO implements UniversityDAOInterface{
    @Autowired
    UniversityRepository ar;

    @Override
    public Iterable<University> findAll() {
        return ar.findAll();
    }

    @Override
    public University save(University university) {
        return ar.save(university);
    }

    @Override
    public void delete(String id) {
        ar.deleteById(id);
    }

    @Override
    public University findById(String id) {
        return ar.findById(id).get();
    }
}
