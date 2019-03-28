/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.repository.cv;

import com.bm.bootcampmanagement.entities.Degree;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lusiana
 */
@Repository
public interface DegreeRepository extends CrudRepository<Degree, String>{
    @Modifying
    @Query(value = "DELETE FROM tb_m_degree where id = ?1", nativeQuery = true)
    public void deleteById(String id);
}
