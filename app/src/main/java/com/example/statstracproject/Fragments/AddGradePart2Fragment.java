package com.example.statstracproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.statstracproject.R;
import com.example.statstracproject.adapters.GradesAdapter;
import com.example.statstracproject.api.GradesApi;
import com.example.statstracproject.dto.GradeEntryDto;
import com.example.statstracproject.models.Grade;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddGradePart2Fragment extends Fragment {

    RadioGroup radioGroup;
    private EditText noteEditText;
    private Double gradeValue=3.5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView=inflater.inflate(R.layout.fragment_add_grade_part2, container, false);


        radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        Button buttonConfrim = rootView.findViewById(R.id.buttonConfirm);

        Long payload = getArguments().getLong("subjectId", 69);
        noteEditText=rootView.findViewById(R.id.editTextAddSubjectNote);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButton2:
                        gradeValue = 2.0;

                        break;
                    case R.id.radioButton25:
                        gradeValue = 2.5;

                        break;
                    case R.id.radioButton3:
                        gradeValue = 3.0;

                        break;
                    case R.id.radioButton35:
                        gradeValue = 3.5;

                        break;
                    case R.id.radioButton4:
                        gradeValue = 4.0;

                        break;
                    case R.id.radioButton45:
                        gradeValue = 4.5;

                        break;
                    case R.id.radioButton5:
                        gradeValue = 5.0;
                        break;
                }
                Toast.makeText(rootView.getContext(), "Selected grade: " + gradeValue, Toast.LENGTH_LONG).show();

            }
        });


        buttonConfrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofitInstance(rootView,payload,gradeValue,noteEditText.getText().toString());




            }
        });


        return rootView;
    }


    private void retrofitInstance(View rootView,Long subjectId, Double gradeValue, String note) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GradesApi gradesApi = retrofit.create(GradesApi.class);
        GradeEntryDto dtoToSend=new GradeEntryDto(subjectId,gradeValue,note);

        retrofit2.Call<GradeEntryDto> call= gradesApi.addNewGrade(dtoToSend);

        call.enqueue(new Callback<GradeEntryDto>() {
            @Override
            public void onResponse(retrofit2.Call<GradeEntryDto> call, Response<GradeEntryDto> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(rootView.getContext(), "Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

            }

            @Override
            public void onFailure(retrofit2.Call<GradeEntryDto> call, Throwable t) {
                System.out.println("retrofitfailiure");
            }
        });

    }

}