package com.example.statstracproject.api;


import com.example.statstracproject.models.Subject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SubjectsApi {

    @GET("subject")
    Call<ArrayList<Subject>> getSubjects();
}
