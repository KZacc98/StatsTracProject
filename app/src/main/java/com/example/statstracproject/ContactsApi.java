package com.example.statstracproject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsApi {

    @GET("contact")
    Call<ArrayList<Contact>> getContacts();


}
