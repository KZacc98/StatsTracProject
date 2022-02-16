package com.example.statstracproject.api;

import com.example.statstracproject.models.Grade;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GradesApi {

    @GET("grade")
    Call<ArrayList<Grade>> getGrades();
}
