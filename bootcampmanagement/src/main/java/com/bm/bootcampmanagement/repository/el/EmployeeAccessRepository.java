/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.repository.el;


import com.bm.bootcampmanagement.entities.Employeeaccess;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Firsta
 */
@Repository
public interface EmployeeAccessRepository extends CrudRepository<Employeeaccess, String>{
    @Modifying
    @Query (value = "DELETE FROM tb_t_employee_access where id = ?1", nativeQuery = true)
    public void deleteById(String id);
}
