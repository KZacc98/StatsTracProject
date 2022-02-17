package com.example.statstracproject.models;

public class Subject {

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", title='" + title + '\'' +
                '}';
    }

    public Subject() {
    }

    public Subject(Long subjectId, String title) {
        this.subjectId = subjectId;
        this.title = title;
    }

    private Long subjectId;
    private String title;

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
}
