/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.bm;

import com.bm.bootcampmanagement.entities.Placement;


/**
 *
 * @author Firsta
 */

public interface PlacementDAOInterface {
    Iterable<Placement> findAll();
    Placement savePlacement(Placement placement);
    void deletePlacementById(String id);
}
