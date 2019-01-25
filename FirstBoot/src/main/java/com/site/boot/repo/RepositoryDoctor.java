/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.boot.repo;

import com.site.boot.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface RepositoryDoctor extends MongoRepository<Doctor,String> {
    
}
