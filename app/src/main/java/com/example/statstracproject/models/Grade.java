package com.example.statstracproject.models;

public class Grade {
    private Long gradeId;
    private Double gradeValue;
    private String note;
    private Long subjectId;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Double getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(Double gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Grade() {
    }

    public Grade(Long gradeId, Double gradeValue, String note, Long subjectId) {
        this.gradeId = gradeId;
        this.gradeValue = gradeValue;
        this.note = note;
        this.subjectId = subjectId;
    }
}