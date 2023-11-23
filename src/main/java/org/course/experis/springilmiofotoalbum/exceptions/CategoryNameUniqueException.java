package org.course.experis.springilmiofotoalbum.exceptions;

import org.course.experis.springilmiofotoalbum.model.Category;

public class CategoryNameUniqueException extends RuntimeException {
    public CategoryNameUniqueException(String message) {
        super(message);
    }
}
