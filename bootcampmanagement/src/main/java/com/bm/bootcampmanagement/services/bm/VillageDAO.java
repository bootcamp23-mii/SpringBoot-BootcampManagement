/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.bm;

import com.bm.bootcampmanagement.entities.Village;
import com.bm.bootcampmanagement.repository.bm.VillageRepository;
import com.bm.bootcampmanagement.servicesInterface.bm.VillageDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class VillageDAO implements VillageDAOInterface{
    
    @Autowired
    VillageRepository vr;
    
    @Override
    public Iterable<Village> findAll() {
        return vr.findAll();
    }

    @Override
    public Village saveVillage(Village village) {
        return vr.save(village);
    }

    @Override
    public void deleteVillageById(String id) {
       vr.deleteById(id);
    }
    
}
