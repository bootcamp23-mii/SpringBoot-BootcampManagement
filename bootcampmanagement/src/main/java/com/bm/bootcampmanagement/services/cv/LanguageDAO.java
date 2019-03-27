/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Language;
import com.bm.bootcampmanagement.repository.cv.LanguageRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.LanguageDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerydanu
 */
@Service
public class LanguageDAO implements LanguageDAOInterface {
    
    @Autowired
    LanguageRepository lr;
    
    @Override
    public Iterable<Language> findAll() {
        return lr.findAll();
    }

    @Override
    public Language save(Language language) {
        return lr.save(language);
    }

    @Override
    public void delete(String id) {
        lr.deleteById(id);
    }

    @Override
    public Language findById(String id) {
        return lr.findById(id).get();
    }
    
}
