package org.course.experis.springilmiofotoalbum.exceptions;

public class PhotoTitleUniqueException extends RuntimeException{
    public PhotoTitleUniqueException(String message){
        super(message);
    }
}
