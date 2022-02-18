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
        holder.txtGradeId.setText(grades.get(position).getGradeId().toString());

        holder.txtGradeValue.setText(grades.get(position).getGradeValue().toString());

        holder.txtGradeNote.setText(grades.get(position).getNote());

        holder.txtSubjectId.setText(grades.get(position).getSubjectId().toString());
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

        private TextView txtGradeId;
        private TextView txtGradeValue;
        private TextView txtGradeNote;
        private TextView txtSubjectId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtGradeId = itemView.findViewById(R.id.gradeListGradeId);
            txtGradeValue = itemView.findViewById(R.id.gradeListGradeValue);
            txtGradeNote = itemView.findViewById(R.id.gradeListGradeNote);
            txtSubjectId = itemView.findViewById(R.id.gradeListGradeSubjectId);
        }
    }
}
