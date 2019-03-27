/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.servicesInterface.cv;

import com.bm.bootcampmanagement.entities.Skill;

/**
 *
 * @author gerydanu
 */
public interface SkillDAOInterface {
    Iterable<Skill> findAll();
    Skill findById(String id);
    Skill save(Skill skill);
    void delete(String id);
}
