/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Major;
import com.bm.bootcampmanagement.repository.cv.MajorRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.MajorDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lusiana
 */
@Service
public class MajorDAO implements MajorDAOInterface{
    @Autowired
    MajorRepository ar;

    @Override
    public Iterable<Major> findAll() {
        return ar.findAll();
    }

    @Override
    public Major save(Major major) {
        return ar.save(major);
    }

    @Override
    public void delete(String id) {
        ar.deleteById(id);
    }

    @Override
    public Major findById(String id) {
        return ar.findById(id).get();
    }
}
