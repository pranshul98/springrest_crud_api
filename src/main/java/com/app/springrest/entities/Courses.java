package com.app.springrest.entities;

public class Courses {
    private int id;
    private String title;
    private String description;

    public Courses(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Courses() {
        super();
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
