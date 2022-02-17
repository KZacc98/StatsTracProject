package com.example.statstracproject.dto;

public class GradeEntryDto {
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Double getGradeValue() {
        return gradeValue;
    }

    @Override
    public String toString() {
        return "GradeEntryDto{" +
                "subjectId=" + subjectId +
                ", gradeValue=" + gradeValue +
                ", note='" + note + '\'' +
                '}';
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

    public GradeEntryDto() {
    }

    public GradeEntryDto(Long subjectId, Double gradeValue, String note) {
        this.subjectId = subjectId;
        this.gradeValue = gradeValue;
        this.note = note;
    }

    private Long subjectId;
    private Double gradeValue;
    private String note;

}
