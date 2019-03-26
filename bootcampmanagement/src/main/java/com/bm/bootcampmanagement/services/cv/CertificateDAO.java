/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Certificate;
import com.bm.bootcampmanagement.repository.cv.CertificateRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.CertificateDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lusiana
 */
@Service
public class CertificateDAO implements CertificateDAOInterface{

    @Autowired
    CertificateRepository cr;
    
    @Override
    public Iterable<Certificate> findAll() {
        return cr.findAll();
    }

    @Override
    public Certificate findById(String id) {
        return cr.findById(id).get();
    }

    @Override
    public Certificate save(Certificate certificate) {
        return cr.save(certificate);
    }

    @Override
    public void delete(String id) {
        cr.deleteById(id);
    }
    
}
