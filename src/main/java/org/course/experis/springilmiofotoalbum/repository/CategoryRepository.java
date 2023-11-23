package org.course.experis.springilmiofotoalbum.repository;

import java.util.List;

import org.course.experis.springilmiofotoalbum.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category>  findByOrderByName();

    public default List<Category> getAll() {
        return findByOrderByName();
    }

    boolean existsByName(String name);

}
