/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.bm;

import com.bm.bootcampmanagement.entities.Village;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public interface VillageDAOInterface {
    Iterable<Village> findAll();
    Village saveVillage(Village village);
    void deleteVillageById(String id);
}
