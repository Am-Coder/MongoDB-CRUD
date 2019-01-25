/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.boot.repo;

import com.site.boot.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface RepositoryStudent extends MongoRepository<Student,String>{
    @Query("{ 'id' : ?0 }")
    Student findUsersById(String name);
}
