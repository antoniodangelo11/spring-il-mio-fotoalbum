package org.course.experis.springilmiofotoalbum.controller;

import org.course.experis.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.course.experis.springilmiofotoalbum.model.Photo;
import org.course.experis.springilmiofotoalbum.service.CategoryService;
import org.course.experis.springilmiofotoalbum.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(@RequestParam Optional<String> search, Model model) {
        model.addAttribute("photoList", photoService.getPhotoList(search));
        return "photos/list";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        try {
            Photo photo = photoService.getPhotoById(id);
            model.addAttribute("photo", photo);
            return "photos/show";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("photo", new Photo());
        model.addAttribute("categoryList", categoryService.getAll());
        return "photos/form";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("photo")
                           Photo formPhoto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAll());
            return "photos/form";
        }
        try {
            Photo savedPhoto = photoService.createPhoto(formPhoto);
            return "redirect:/photos/show/" + savedPhoto.getId();
        } catch (RuntimeException e) {
            bindingResult.addError(new FieldError(
                    "photo",
                    "title", e.getMessage(),
                    false,
                    null,
                    null,
                    "Title must be unique"));
            return "photos/form";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("photo", photoService.getPhotoById(id));
            model.addAttribute("categoryList", categoryService.getAll());
            return "/photos/form";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("photo") Photo formPhoto,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAll());
            return "/photos/form";
        }
        try {
            Photo savedPhoto = photoService.editPhoto(formPhoto);
            return "redirect:/photos/show/" + savedPhoto.getId();
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            Photo photoToDelete = photoService.getPhotoById(id);
            photoService.deletePhoto(id);
            redirectAttributes.addFlashAttribute(
                    "message",
                    "The "
                            + photoToDelete.getTitle()
                            + " deleted!");
            return "redirect:/photos";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
