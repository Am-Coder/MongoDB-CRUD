/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.boot.repo;

import com.mongodb.MongoSocketReadException;
import com.mongodb.client.result.DeleteResult;
import com.site.boot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */
@Component
public class DBaccess {
    @Autowired 
    private RepositoryDoctor repoDoc;
    
    @Autowired
    MongoTemplate mongoTemplate;
            
            
    @Autowired
    private RepositoryStudent repoStu;
    
    private final String special="Prematurely reached end of stream; nested exception is com.mongodb.MongoSocketReadException: Prematurely reached end of stream";
    
    public int addStudent(Student student){
        int i;
        try {
      
        repoStu.insert(student);
        i=1;
        }

        catch(Exception e){
            i=0;
            System.out.println(e.getMessage());
        }
        return i;
    }
    
    public Student findStudent(String rollNo){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(rollNo));
        Student stu=mongoTemplate.findOne(query, Student.class);
        return stu;
    }
    
    public DeleteResult deleteStudent(String rollNo){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(rollNo));
        DeleteResult del=mongoTemplate.remove(query,Student.class);
        return del;
    }
      
    public Student updateStudent(String rollNo,String newName){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(rollNo));
        Update update=new Update();
        update.set("firstName", newName);
        Student stu=mongoTemplate.findAndModify(query,update,Student.class);
        return stu;
    }
}
