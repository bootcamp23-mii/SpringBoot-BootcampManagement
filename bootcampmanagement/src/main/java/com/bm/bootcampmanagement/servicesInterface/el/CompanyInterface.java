/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.Company;

/**
 *
 * @author Firsta
 */
public interface CompanyInterface {
    Iterable<Company> findAll();
    Company findById(String id);
    Company save(Company company);
    void delete(String id);
}
