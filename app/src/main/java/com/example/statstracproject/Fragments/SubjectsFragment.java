package com.example.statstracproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.statstracproject.R;
import com.example.statstracproject.adapters.SubjectsRecyclerViewAdapter;
import com.example.statstracproject.api.SubjectsApi;
import com.example.statstracproject.models.Subject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {link Fragment} subclass.
 * Use the {link ContactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubjectsFragment extends Fragment {


//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public ContactsFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ContactsFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ContactsFragment newInstance(String param1, String param2) {
//        ContactsFragment fragment = new ContactsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//    }

    private ArrayList<Subject> subjectsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_subjects, container, false);
        // 1. get a reference to recyclerView
        RecyclerView contactsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        // 2. set layoutManger


        SubjectsRecyclerViewAdapter adapter = new SubjectsRecyclerViewAdapter(rootView.getContext());
        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));
        retrofitInstance(adapter, rootView);


        return rootView;
    }


    private void retrofitInstance(SubjectsRecyclerViewAdapter adapter, View rootView) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SubjectsApi subjectsApi= retrofit.create(SubjectsApi.class);

        Call<ArrayList<Subject>> call = subjectsApi.getSubjects();
        call.enqueue(new Callback<ArrayList<Subject>>() {
            @Override
            public void onResponse(Call<ArrayList<Subject>> call, Response<ArrayList<Subject>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(rootView.getContext(), "Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                subjectsList = response.body();//tu wpadają rzeczy z serwera
                adapter.setSubjects(subjectsList);
            }

            @Override
            public void onFailure(Call<ArrayList<Subject>> call, Throwable t) {
                Toast.makeText(requireContext(), "Retrofit Failiure: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}






