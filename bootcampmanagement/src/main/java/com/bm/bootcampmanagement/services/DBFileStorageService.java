/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.services;

import com.bm.bootcampmanagement.entities.Employee;
import com.bm.bootcampmanagement.exception.FileStorageException;
import com.bm.bootcampmanagement.exception.MyFileNotFoundException;
import com.bm.bootcampmanagement.repository.DBRepository;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Lusiana
 */
@Service
public class DBFileStorageService {

    @Autowired
    private DBRepository dbr;

    public Employee storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Employee e = dbr.findById("14304").get();
            Employee employee = new Employee(e.getId(), e.getName(), e.getBirthdate(), e.getGender(), e.getMarriedstatus(), e.getAddress(), e.getEmail(), e.getPhone(), e.getOnboarddate(),
            e.getPassword(), e.getSecurityqestion(), e.getSecurityanswer(), file.getBytes());

            return dbr.save(employee);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Employee getFile(String fileId) {
        return dbr.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
