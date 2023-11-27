package org.course.experis.springilmiofotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "photos")
public class Photo {

    // ATTRIBUTI

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name must not be blank")
    @Size(max = 255, message = "Length must be less than 255")
    private String title;

    @NotBlank(message = "Description must not be blank")
    @Size(max = 1255, message = "Length must be less than 1255")
    @Column(length = 1255)
    private String description;

    @NotBlank(message = "Photo must not be blank")
    @Size(max = 2500, message = "Length must be less than 2500")
    @Column(length = 2500)
    private String url;

    private boolean visible = false;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories;


    // GETTER E SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

