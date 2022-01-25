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

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton fab;
    private RecyclerView contactsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fab pressed", Toast.LENGTH_SHORT).show();
            }
        });

        contactsRecyclerView=findViewById(R.id.recyclerView);

        ArrayList<Contact>contacts=new ArrayList<>();//irl tu wpadają rzeczy z serwera
        contacts.add(new Contact("Maddy Perez","madper@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/1/13/Maddy_Perez.jpg/revision/latest?cb=20200821140939.jpg"));
        contacts.add(new Contact("Jules Vaughm","juulz@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/0/06/Jules_Vaughn.jpg/revision/latest/scale-to-width-down/1200?cb=20190617063942.jpg"));
        contacts.add(new Contact("cassie Howard","cascas@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/f/f9/Euphoria_S2_Cassie.jpg/revision/latest?cb=20220104035238.jpg"));
        contacts.add(new Contact("Elliot","ellie@wp.pl","https://static.wikia.nocookie.net/euphoria-hbo/images/7/7d/Euphoria_S2_Elliot.jpg/revision/latest?cb=20211225055956.jpg"));

        ContactsRecyclerViewAdapter adapter= new ContactsRecyclerViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }
}