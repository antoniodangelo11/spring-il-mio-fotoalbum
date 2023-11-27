package org.course.experis.springilmiofotoalbum.exceptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException (String contact){
        super (contact);
    }
}