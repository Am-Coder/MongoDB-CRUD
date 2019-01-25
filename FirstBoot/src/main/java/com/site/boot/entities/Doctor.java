/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.boot.entities;

//import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author HP
 */
//@QueryEntity
@Document
public class Doctor {
    private String docName;
    private String docMail;
    private String docPhoneNumber;
    private String docPassword;

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocMail() {
        return docMail;
    }

    public void setDocMail(String docMail) {
        this.docMail = docMail;
    }

    public String getDocPhoneNumber() {
        return docPhoneNumber;
    }

    public void setDocPhoneNumber(String docPhoneNumber) {
        this.docPhoneNumber = docPhoneNumber;
    }

    public String getDocPassword() {
        return docPassword;
    }

    public void setDocPassword(String docPassword) {
        this.docPassword = docPassword;
    }
    
    
    
    
    
    
    
    
}
