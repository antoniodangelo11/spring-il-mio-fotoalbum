package org.course.experis.springilmiofotoalbum.repository;

import org.course.experis.springilmiofotoalbum.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findByTitleContainingIgnoreCase(String titleKeyword);
    List<Photo> findByVisible(boolean visible);
    List<Photo> findByVisibleAndTitleContainingIgnoreCase(boolean visible, String titleKeyword);
}

