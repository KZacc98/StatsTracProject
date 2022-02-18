package com.example.statstracproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.statstracproject.Fragments.AddGradeFragment;
import com.example.statstracproject.Fragments.AddGradePart2Fragment;
import com.example.statstracproject.Fragments.GradeCardFragment;
import com.example.statstracproject.R;
import com.example.statstracproject.models.Subject;

import java.util.ArrayList;

public class SubjectsRecyclerViewAdapterSmall extends RecyclerView.Adapter<SubjectsRecyclerViewAdapterSmall.ViewHolder> {

    private ArrayList<Subject> subjectsList = new ArrayList<>();
    private Context context;

    public SubjectsRecyclerViewAdapterSmall(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_list_item_small, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //tu wrzucasz rzeczy które mają być w kartach recyclerview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(subjectsList.get(position).getTitle());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, subjectsList.get(holder.getAdapterPosition()).getTitle() + " Selected", Toast.LENGTH_SHORT).show();

                Bundle bundle =new Bundle();
                bundle.putLong("subjectId",subjectsList.get(holder.getAdapterPosition()).getSubjectId());

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                AddGradePart2Fragment myFragment = new AddGradePart2Fragment();
                myFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, myFragment).addToBackStack(null).commit();

            }
        });


        Glide.with(context)
                .asBitmap()
                .load("https://img.freepik.com/darmowe-wektory/trener-przemawia-przed-publicznoscia-mentor-prezentujacy-wykresy-i-raporty-spotkanie-pracownikow-na-szkoleniu-biznesowym-seminarium-lub-konferencji-ilustracja-wektorowa-do-prezentacji-wykladu-edukacji_74855-8294.jpg?w=1480")
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return subjectsList.size();
    }

    public void setSubjects(ArrayList<Subject> subjectsList) {
        this.subjectsList = subjectsList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private ImageView image;
        private CardView parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            image = itemView.findViewById(R.id.image);
            parent = itemView.findViewById(R.id.parent);
        }
    }


}
