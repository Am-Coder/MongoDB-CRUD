/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.boot.controllers;

import com.mongodb.client.result.DeleteResult;
import com.site.boot.entities.Student;
import com.site.boot.repo.DBaccess;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class Control {
    
    
    private static final Logger logger = LoggerFactory.getLogger(Control.class);

    
    
    @Autowired 
    DBaccess dataControl;
    
    @RequestMapping(value="/")
    public ModelAndView begin(ModelAndView mv){
        mv.setViewName("index");
        return mv;
    }
    
    
    @RequestMapping(value="/Student",method=RequestMethod.GET)
    public ModelAndView addingStudent(HttpServletRequest req,ModelAndView mv){
        Student stu=new Student();
        stu.setFirstName(req.getParameter("firstName"));
        stu.setLastName(req.getParameter("lastName"));
        stu.setId(req.getParameter("id"));
        int i=dataControl.addStudent(stu);  
        if(i==1)
            mv.setViewName("Success");
        else
            mv.setViewName("failed");
        return mv;
    }
    
     @RequestMapping(value="/Find",method=RequestMethod.GET)
    public ModelAndView findingStudent(HttpServletRequest req,ModelAndView mv){
        
        
        Student stu=dataControl.findStudent(req.getParameter("id"));
        if(stu==null){
            mv.setViewName("failed");
        }
        else{
            mv.setViewName("Success");
        }
        return mv;
    }   
    
    @RequestMapping(value="/Update",method=RequestMethod.GET)
    public ModelAndView updatingStudent(HttpServletRequest req,ModelAndView mv){
        
        
        Student stu=dataControl.updateStudent(req.getParameter("id"),req.getParameter("newRollNo"));
        if(stu==null){
            mv.setViewName("failed");
        }
        else{
            mv.setViewName("Success");
        }
        return mv;
    }
    @RequestMapping(value="/Delete",method=RequestMethod.GET)
    public ModelAndView deleteStudent(HttpServletRequest req,ModelAndView mv){
        
        
        DeleteResult del=dataControl.deleteStudent(req.getParameter("id"));
        if(del.getDeletedCount()==0){
            mv.setViewName("failed");
        }
        else{
            mv.setViewName("Success");
        }
        return mv;
    }
    
    
    @RequestMapping(value="/move")
    public ModelAndView checknlp(ModelAndView mv){
        mv.setViewName("Input");
        return mv;
    }
    @RequestMapping(value="/nlp")
    public ModelAndView checknlp(@RequestParam("check") String check,ModelAndView mv){
        nlppro.init();
        logger.info(check);
        logger.info("Sentiment:----"+nlppro.findSentiment("I am a bad guy" ));


        mv.setViewName("answer");
        return mv;
    }
}
