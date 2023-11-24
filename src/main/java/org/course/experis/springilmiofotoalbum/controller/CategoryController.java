package org.course.experis.springilmiofotoalbum.controller;

import org.course.experis.springilmiofotoalbum.exceptions.CategoryNameUniqueException;
import org.course.experis.springilmiofotoalbum.model.Category;
import org.course.experis.springilmiofotoalbum.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("categoryObj", new Category());
        return "categories/list";
    }

    @PostMapping
    public String doSave(@Valid @ModelAttribute("categoryObj")
                         Category formCategory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAll());
            return "categories/form";
        }
        try {
            categoryService.saveCategory(formCategory);
            return "redirect:/categories";
        } catch (CategoryNameUniqueException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A category with name " + e.getMessage() + "already exist");
        }

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Category deleteCategory = categoryService.getCategoryById(id);
            categoryService.deleteCategory(deleteCategory, id);
            redirectAttributes.addFlashAttribute(
                    "message",
                    "The " + deleteCategory.getName() + " deleted!");
            return "redirect:/categories";
        } catch (CategoryNameUniqueException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());

        }
    }
}

