package com.example.statstracproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.statstracproject.Fragments.HomeFragment;
import com.example.statstracproject.Fragments.SubjectsFragment;
import com.example.statstracproject.Fragments.AddFragment;
import com.example.statstracproject.R;
import com.example.statstracproject.api.SubjectsApi;
import com.example.statstracproject.models.Subject;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AddSubjectDialog.AddSubjectDialogListener {

    ChipNavigationBar chipNavigationBar;


    //private ArrayList<Contact> contactsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = findViewById(R.id.bottomNavBar);
        chipNavigationBar.setItemSelected(R.id.bottomNavBar_home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();

        bottomMenu();

    }


    //    private void retrofitInstance(ContactsRecyclerViewAdapter adapter) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:8080/api/v1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ContactsApi contactsApi = retrofit.create(ContactsApi.class);
//
//        Call<ArrayList<Contact>> call = contactsApi.getContacts();
//        call.enqueue(new Callback<ArrayList<Contact>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Contact>> call, Response<ArrayList<Contact>> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, "Code: " + response.code(), Toast.LENGTH_LONG).show();
//                    return;
//                }
//                contactsList = response.body();//tu wpadaj?? rzeczy z serwera
//                adapter.setContacts(contactsList);
//                //String tstmsg=contactsList.toString();
//                //Toast.makeText(MainActivity.this, tstmsg, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Contact>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Retrofit Failiure: " + t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.bottomNavBar_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.bottomNavBar_contacts:
                        fragment = new SubjectsFragment();
                        break;
                    case R.id.bottomNavBar_settings:
                        fragment = new AddFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
            }
        });

    }

    @Override
    public void addNewSubject(String subjectTitle) {
        Subject subject=new Subject(subjectTitle);
        retrofitInstance(subject);
    }



    private void retrofitInstance(Subject subject) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SubjectsApi subjectsApi = retrofit.create(SubjectsApi.class);

        Call<Subject> call = subjectsApi.addNewSubject(subject);
        call.enqueue(new Callback<Subject>() {

            @Override
            public void onResponse(Call<Subject> call, Response<Subject> response) {
                System.out.println("#################### RESPONSE OKAY");
            }

            @Override
            public void onFailure(Call<Subject> call, Throwable t) {
                System.out.println("#################### RESPONSE NOT OKAY$$$$$$$$$$$$$$$$$$$$$$$$");
            }
        });
    }
}