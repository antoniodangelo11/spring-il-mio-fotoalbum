package org.course.experis.springilmiofotoalbum.exceptions;

import org.course.experis.springilmiofotoalbum.model.Photo;

public class PhotoNotFoundException extends RuntimeException{
    public PhotoNotFoundException(String message) {
        super(message);
    }
}
