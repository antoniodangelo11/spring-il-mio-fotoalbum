package org.course.experis.springilmiofotoalbum.repository;

import org.course.experis.springilmiofotoalbum.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
