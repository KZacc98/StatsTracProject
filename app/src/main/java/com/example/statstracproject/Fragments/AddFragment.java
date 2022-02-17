package com.example.statstracproject.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.statstracproject.R;

public class AddFragment extends Fragment {

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



                Toast.makeText(rootView.getContext(), "AddSubject Clicked", Toast.LENGTH_LONG).show();
            }
        });







        return rootView;

    }

}