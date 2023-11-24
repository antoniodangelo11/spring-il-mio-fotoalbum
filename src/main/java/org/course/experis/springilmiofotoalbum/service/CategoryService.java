package org.course.experis.springilmiofotoalbum.service;

import org.course.experis.springilmiofotoalbum.exceptions.CategoryNameUniqueException;
import org.course.experis.springilmiofotoalbum.model.Category;
import org.course.experis.springilmiofotoalbum.model.Photo;
import org.course.experis.springilmiofotoalbum.repository.CategoryRepository;
import org.course.experis.springilmiofotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PhotoRepository photoRepository;

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

    public void deleteCategory (Integer id) {
        Category categoryDelete = getCategoryById(id);
        List<Photo> photos = categoryDelete.getPhotos();
        if (!photos.isEmpty()){
            for (Photo photo : photos){
                List <Category> categories = photo.getCategories();
                categories.remove(categoryDelete);
            }
            categoryDelete.setPhotos(new ArrayList<>());
        }
        categoryRepository.deleteById(id);
    }
}