package com.example.statstracproject.api;

import com.example.statstracproject.models.Contact;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsApi {

    @GET("contact")
    Call<ArrayList<Contact>> getContacts();


}
