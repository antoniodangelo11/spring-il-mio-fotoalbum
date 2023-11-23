package org.course.experis.springilmiofotoalbum.service;

import org.course.experis.springilmiofotoalbum.exceptions.CategoryNameUniqueException;
import org.course.experis.springilmiofotoalbum.model.Category;
import org.course.experis.springilmiofotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findByOrderByName();
    }

    public Category getCategoryById(Integer id) throws CategoryNameUniqueException {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new CategoryNameUniqueException("category with id " + id + " not found");
        }
    }

    public void saveCategory(Category category) throws CategoryNameUniqueException {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryNameUniqueException(category.getName());
        }
        category.setName(category.getName().toLowerCase());
        categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}