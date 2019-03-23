/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Province;
import com.bm.bootcampmanagement.repository.el.ProvinceRepository;
import com.bm.bootcampmanagement.servicesInterface.el.ProvinceDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class ProvinceDAO implements ProvinceDAOInterface{
    
    @Autowired
    ProvinceRepository pr;
    
    @Override
    public Iterable<Province> findAll() {
        return pr.findAll();
    }

    @Override
    public Province saveProvince(Province province) {
        return pr.save(province);
    }

    @Override
    public void deleteProvinceById(String id) {
        pr.deleteById(id);
    }
    
}
