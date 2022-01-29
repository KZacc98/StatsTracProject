package com.example.statstracproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton fab;
    private RecyclerView contactsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fab pressed", Toast.LENGTH_SHORT).show();
            }
        });

        contactsRecyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactsApi contactsApi = retrofit.create(ContactsApi.class);

        Call<List<Contact>> call = contactsApi.getContacts();


        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                List<Contact> contactList = response.body();//tu wpadają rzeczy z serwera w postaci listy
                String tstmsg=contactList.toString();
                Toast.makeText(MainActivity.this, tstmsg, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Retrofit Failiure: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        ArrayList<Contact> contacts = new ArrayList<>();//irl tu wpadają rzeczy z serwera
//        contacts.add(new Contact("Maddy Perez","madper@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/1/13/Maddy_Perez.jpg/revision/latest?cb=20200821140939.jpg"));
//        contacts.add(new Contact("Jules Vaughm","juulz@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/0/06/Jules_Vaughn.jpg/revision/latest/scale-to-width-down/1200?cb=20190617063942.jpg"));
//        contacts.add(new Contact("cassie Howard","cascas@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/f/f9/Euphoria_S2_Cassie.jpg/revision/latest?cb=20220104035238.jpg"));
//        contacts.add(new Contact("Elliot","ellie@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/7/7d/Euphoria_S2_Elliot.jpg/revision/latest?cb=20211225055956.jpg"));

        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}