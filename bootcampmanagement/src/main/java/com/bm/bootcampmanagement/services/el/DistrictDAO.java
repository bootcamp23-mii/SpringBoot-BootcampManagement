/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.District;
import com.bm.bootcampmanagement.repository.el.DistrictRepository;
import com.bm.bootcampmanagement.servicesInterface.el.DistrictDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service

public class DistrictDAO implements DistrictDAOInterface{
    
    @Autowired
    DistrictRepository dr;
    
    @Override
    public Iterable<District> findAll() {
        return dr.findAll();
    }

    @Override
    public District saveDistrict(District district) {
        return dr.save(district);
    }

    @Override
    public void deleteDistrictById(String id) {
        dr.deleteById(id);
    }

    @Override
    public District findById(String id) {
        return dr.findById(id).get();
    }
    
}
