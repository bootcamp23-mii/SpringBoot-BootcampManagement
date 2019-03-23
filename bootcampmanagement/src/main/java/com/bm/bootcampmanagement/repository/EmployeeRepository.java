/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.repository;

import com.bm.bootcampmanagement.entities.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FES
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>
{
    @Modifying
    @Query(value = "DELETE FROM Employee where id = ?1", nativeQuery = true)
    public void deleteById(String id);
}
