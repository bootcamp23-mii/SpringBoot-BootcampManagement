/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.Province;


/**
 *
 * @author Firsta
 */

public interface ProvinceDAOInterface {
    Iterable<Province> findAll();
    Province saveProvince(Province province);
    void deleteProvinceById(String id);
}
