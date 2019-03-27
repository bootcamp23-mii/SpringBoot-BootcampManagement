/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Language;

/**
 *
 * @author gerydanu
 */
public interface LanguageDAOInterface {
    
    Iterable<Language> findAll();
    Language findById(String id);
    Language save(Language language);
    void delete(String id);
    
}
