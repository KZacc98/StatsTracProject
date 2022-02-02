package com.example.statstracproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.statstracproject.models.Contact;
import com.example.statstracproject.api.ContactsApi;
import com.example.statstracproject.adapters.ContactsRecyclerViewAdapter;
import com.example.statstracproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Contact> contactsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Fab pressed", Toast.LENGTH_SHORT).show();
//            }
//        });

        RecyclerView contactsRecyclerView = findViewById(R.id.recyclerView);

        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);


        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        retrofitInstance(adapter);






    }

    private void retrofitInstance(ContactsRecyclerViewAdapter adapter){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactsApi contactsApi = retrofit.create(ContactsApi.class);

        Call<ArrayList<Contact>> call = contactsApi.getContacts();
        call.enqueue(new Callback<ArrayList<Contact>>() {
            @Override
            public void onResponse(Call<ArrayList<Contact>> call, Response<ArrayList<Contact>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                contactsList = response.body();//tu wpadają rzeczy z serwera
                adapter.setContacts(contactsList);
                //String tstmsg=contactsList.toString();
                //Toast.makeText(MainActivity.this, tstmsg, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<Contact>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Retrofit Failiure: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}