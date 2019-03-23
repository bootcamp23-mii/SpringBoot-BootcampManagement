/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.District;


/**
 *
 * @author Firsta
 */
public interface DistrictDAOInterface {
    Iterable<District> findAll();
    District saveDistrict(District district);
    void deleteDistrictById(String id);
}
