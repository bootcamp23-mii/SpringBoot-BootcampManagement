/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Placement;
import com.bm.bootcampmanagement.repository.el.PlacementRepository;
import com.bm.bootcampmanagement.servicesInterface.el.PlacementDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class PlacementDAO implements PlacementDAOInterface{
    
    @Autowired
    PlacementRepository placementRepository;
    
    @Override
    public Iterable<Placement> findAll() {
        return placementRepository.findAll();
    }

    @Override
    public Placement savePlacement(Placement placement) {
        return  placementRepository.save(placement);
    }

    @Override
    public void deletePlacementById(String id) {
        placementRepository.deleteById(id);
    }
    
}
