/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Subdistrict;
import com.bm.bootcampmanagement.repository.el.SubDistrictRepository;
import com.bm.bootcampmanagement.servicesInterface.el.SubDistrictDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class SubDistrictDAO implements SubDistrictDAOInterface {

    @Autowired
    SubDistrictRepository sdr;

    @Override
    public Iterable<Subdistrict> findAll() {
        return sdr.findAll();
    }

    @Override
    public Subdistrict saveSubdistrict(Subdistrict subdistrict) {
        return sdr.save(subdistrict);
    }

    @Override
    public void deleteSubdistrictById(String id) {
        sdr.deleteById(id);
    }

    @Override
    public Subdistrict findById(String id) {
        return sdr.findById(id).get();
    }

}
