/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.services.*;
import com.bm.bootcampmanagement.entities.Organization;
import com.bm.bootcampmanagement.repository.cv.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bm.bootcampmanagement.servicesInterface.cv.OrganizationDAOInterface;

/**
 *
 * @author FES
 */
@Service
public class OrganizationDAO implements OrganizationDAOInterface{
         
    @Autowired
    OrganizationRepository ar;

    @Override
    public Iterable<Organization> findAll() {
        return ar.findAll();
    }

    @Override
    public Organization save(Organization organization) {
        return ar.save(organization);
    }

    @Override
    public void delete(String id) {
        ar.deleteById(id);
    }

    @Override
    public Organization findById(String id) {
        return ar.findById(id).get();
    }

  
}
