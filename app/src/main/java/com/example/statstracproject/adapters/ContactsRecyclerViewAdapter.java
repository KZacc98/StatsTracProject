package com.example.statstracproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.statstracproject.R;
import com.example.statstracproject.models.Contact;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contact> contactsList=new ArrayList<>();
    private Context context;

    public ContactsRecyclerViewAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    //tu wrzucasz rzeczy które mają być w kartach recyclerview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(contactsList.get(position).getName());
        holder.txtEmail.setText(contactsList.get(position).getEmail());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, contactsList.get(holder.getAdapterPosition()).getName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(contactsList.get(position)
                        .getImageUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public void setContacts(ArrayList<Contact> contactsList) {
        this.contactsList = contactsList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName, txtEmail;
        private ImageView image;
        private CardView parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtEmail=itemView.findViewById(R.id.txtEmail);
            image=itemView.findViewById(R.id.image);
            parent=itemView.findViewById(R.id.parent);
        }
    }



}
