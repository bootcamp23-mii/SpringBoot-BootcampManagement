/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface;

import com.bm.bootcampmanagement.entities.Role;

/**
 *
 * @author gerydanu
 */
public interface RoleDAOInterface {
    
    Iterable<Role> findAll();
    Role findById(String id);
    Role save(Role role);
    void delete(String id);
    
}
