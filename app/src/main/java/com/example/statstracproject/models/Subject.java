package com.example.statstracproject.models;

public class Subject {

    private Long subjectId;
    private String title;


    @Override
    public String toString() {
        return "Subject{" +
                "id=" + subjectId +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Subject(Long subjectId, String title) {
        this.subjectId = subjectId;
        this.title = title;
    }


}
