/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.el;

import com.bm.bootcampmanagement.entities.Company;
import com.bm.bootcampmanagement.repository.el.CompanyRepository;
import com.bm.bootcampmanagement.servicesInterface.el.CompanyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Firsta
 */
@Service
public class CompanyDAO implements CompanyInterface{
    
    @Autowired
    CompanyRepository cr;
    
    @Override
    public Iterable<Company> findAll() {
        return cr.findAll();
    }

    @Override
    public Company findById(String id) {
        return cr.findById(id).get();
    }

    @Override
    public Company save(Company company) {
        return cr.save(company);
    }

    @Override
    public void delete(String id) {
        cr.deleteById(id);
    }
    
}
