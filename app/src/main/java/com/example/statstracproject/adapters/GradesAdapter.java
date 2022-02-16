package com.example.statstracproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.statstracproject.R;
import com.example.statstracproject.models.Grade;
import com.example.statstracproject.models.Subject;

import java.util.ArrayList;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.ViewHolder> {

    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();
    private Context context;

    public GradesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtGrade.setText(grades.get(position).getGradeValue().toString() + " GRADE ID: "
                + grades.get(position).getGradeId().toString() + " SUBJECT ID: "+ grades.get(position).getSubjectId().toString());

    }

    @Override
    public int getItemCount() {
        return grades.size();
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtGrade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtGrade = itemView.findViewById(R.id.gradeListItemTextView);
        }
    }
}
