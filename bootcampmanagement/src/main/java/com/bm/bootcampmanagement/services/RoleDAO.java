/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services;

import com.bm.bootcampmanagement.entities.Employeerole;
import com.bm.bootcampmanagement.entities.Role;
import com.bm.bootcampmanagement.repository.RoleRepository;
import com.bm.bootcampmanagement.servicesInterface.RoleDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerydanu
 */
@Service
public class RoleDAO  implements RoleDAOInterface {
    
    @Autowired
    RoleRepository rr;
    
    @Override
    public Iterable<Role> findAll() {
        return rr.findAll();
    }

    @Override
    public Role save(Role role) {
        return rr.save(role);
    }

    @Override
    public void delete(String id) {
        rr.deleteById(id);
    }

    @Override
    public Role findById(String id) {
        return rr.findById(id).get();
    }
}
