package com.example.statstracproject.models;

public class Subject {

    private Long id;
    private String title;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Subject(Long id, String title) {
        this.id = id;
        this.title = title;
    }


}
