package org.course.experis.springilmiofotoalbum.service;

import org.course.experis.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.course.experis.springilmiofotoalbum.model.Photo;
import org.course.experis.springilmiofotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getPhotoList() {
        return photoRepository.findAll();
    }

    public List<Photo> getPhotoList(Optional<String> search) {

        if (search.isPresent()) {
            return
                    photoRepository.findByTitleContainingIgnoreCase(search.get());
        } else {
            return photoRepository.findAll();
        }
    }

    public Photo getPhotoById(Integer id) throws PhotoNotFoundException {
        Optional<Photo> result = photoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new PhotoNotFoundException("photo with id " + id + " not found");
        }
    }

    public Photo createPhoto(Photo photo) throws PhotoNotFoundException {
        try {
            return photoRepository.save(photo);
        } catch (RuntimeException e) {
            throw new PhotoNotFoundException(photo.getTitle());
        }
    }

    public Photo editPhoto(Photo photo) throws PhotoNotFoundException {
        Photo photoToEdit = getPhotoById(photo.getId());
        photoToEdit.setTitle(photo.getTitle());
        photoToEdit.setDescription(photo.getDescription());
        photoToEdit.setUrl(photo.getUrl());
        photoToEdit.setVisible(photo.isVisible());
        photoToEdit.setCategories(photo.getCategories());

        return photoRepository.save(photoToEdit);
    }

    public void deletePhoto(Integer id) {
        photoRepository.deleteById(id);
    }

    public Page<Photo> getPage(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }
}
