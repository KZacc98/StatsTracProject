package com.example.statstracproject.models;

public class Grade {
    private Long gradeId;
    private Double gradeValue;
    private String note;
    private Subject subject;

    public Grade(Long gradeId, Double gradeValue, String note, Subject subject) {
        this.gradeId = gradeId;
        this.gradeValue = gradeValue;
        this.note = note;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeValue=" + gradeValue +
                ", note='" + note + '\'' +
                ", subject=" + subject +
                '}';
    }

    public void setGradeValue(Double gradeValue) {
        this.gradeValue = gradeValue;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public Double getGradeValue() {
        return gradeValue;
    }

    public String getNote() {
        return note;
    }

    public Subject getSubject() {
        return subject;
    }

    public Grade() {
    }
}