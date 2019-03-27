/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services.cv;

import com.bm.bootcampmanagement.entities.Skill;
import com.bm.bootcampmanagement.repository.cv.SkillRepository;
import com.bm.bootcampmanagement.servicesInterface.cv.SkillDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerydanu
 */
@Service
public class SkillDAO implements SkillDAOInterface {
    
    @Autowired
    SkillRepository sr;

    @Override
    public Iterable<Skill> findAll() {
        return sr.findAll();
    }

    @Override
    public Skill save(Skill skill) {
        return sr.save(skill);
    }

    @Override
    public void delete(String id) {
        sr.deleteById(id);
    }

    @Override
    public Skill findById(String id) {
        return sr.findById(id).get();
    }
    
}
