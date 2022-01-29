package com.example.statstracproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsApi {

    @GET("contact")
    Call<List<Contact>> getContacts();


}
