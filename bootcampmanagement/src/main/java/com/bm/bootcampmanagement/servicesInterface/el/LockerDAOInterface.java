/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.el;

import com.bm.bootcampmanagement.entities.Locker;


/**
 *
 * @author Firsta
 */

public interface LockerDAOInterface {
    Iterable<Locker> findAll();
    Locker saveLocker(Locker locker);
    void deleteLockerById(String id);
}
