package com.example.statstracproject.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.statstracproject.Activities.AddSubjectDialog;
import com.example.statstracproject.R;
import com.example.statstracproject.adapters.SubjectsRecyclerViewAdapterSmall;
import com.example.statstracproject.api.SubjectsApi;
import com.example.statstracproject.models.Subject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddFragment extends Fragment implements AddSubjectDialog.AddSubjectDialogListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_add, container, false);

        CardView cardviewAddGrade = rootView.findViewById(R.id.addGradeCardView);
        CardView cardviewAddSubject = rootView.findViewById(R.id.addSubjectCardView);


        cardviewAddGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "AddGrade Clicked", Toast.LENGTH_LONG).show();

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                AddGradeFragment myFragment = new AddGradeFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, myFragment).addToBackStack(null).commit();
            }
        });

        cardviewAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();

                Toast.makeText(rootView.getContext(), "AddSubject Clicked", Toast.LENGTH_LONG).show();
            }
        });


        return rootView;

    }

    public void openDialog(){
        AddSubjectDialog addSubjectDialog=new AddSubjectDialog();
        addSubjectDialog.show(getParentFragmentManager(), "Add Subject Dialog");
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