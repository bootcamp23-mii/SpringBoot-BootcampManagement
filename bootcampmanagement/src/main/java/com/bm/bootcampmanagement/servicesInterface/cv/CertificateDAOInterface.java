/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Certificate;

/**
 *
 * @author Lusiana
 */
public interface CertificateDAOInterface {

    Iterable<Certificate> findAll();

    Certificate findById(String id);

    Certificate save(Certificate certificate);

    void delete(String id);
}
