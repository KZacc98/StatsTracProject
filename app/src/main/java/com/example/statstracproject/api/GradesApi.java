package com.example.statstracproject.api;

import com.example.statstracproject.dto.GradeEntryDto;
import com.example.statstracproject.models.Grade;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GradesApi {

    @GET("grade")
    Call<ArrayList<Grade>> getGrades();

    @GET("grade/{subjectId}")
    Call<ArrayList<Grade>> getGradesBySubjectId(@Path("subjectId") Long subjectId);

    @PUT("grade")
    Call<GradeEntryDto> addNewGrade(@Body GradeEntryDto gradeEntryDto);



}
