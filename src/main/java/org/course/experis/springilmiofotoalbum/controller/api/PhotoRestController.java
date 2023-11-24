package org.course.experis.springilmiofotoalbum.controller.api;

import org.course.experis.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.course.experis.springilmiofotoalbum.model.Photo;
import org.course.experis.springilmiofotoalbum.service.PhotoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/photos")
@CrossOrigin
public class PhotoRestController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> index(@RequestParam Optional<String> search) {
        return photoService.getPhotoList(search);
    }

    @GetMapping("/{id}")
    public Photo details(@PathVariable Integer id) {
        try {
            return photoService.getPhotoById(id);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public Photo create(@Valid @RequestBody Photo photo) {
        try {
            return photoService.createPhoto(photo);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Photo update(@PathVariable Integer id, @Valid @RequestBody Photo photo) {
        photo.setId(id);
        try {
            return photoService.editPhoto(photo);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        try {
            Photo photoToDelete = photoService.getPhotoById(id);
            photoService.deletePhoto(id);
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/page")
    public Page<Photo> pagedIndex(
            @RequestParam(name = "size", defaultValue = "2") Integer size,
            @RequestParam(name = "page", defaultValue = "0") Integer page) {

        return photoService.getPage(PageRequest.of(page, size));
    }

    @GetMapping("/page/v2")
    public Page<Photo> pagedIndexV2(@PageableDefault(page = 0, size = 2) Pageable pageable) {
        return photoService.getPage(pageable);
    }
}