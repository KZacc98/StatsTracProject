package com.example.statstracproject.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.statstracproject.R;
import com.example.statstracproject.models.Subject;

import java.util.concurrent.CancellationException;

public class AddSubjectDialog extends AppCompatDialogFragment {
    private EditText editTextSubjectTitle;
    private AddSubjectDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener=(AddSubjectDialogListener) context;
        } catch (ClassCastException e) {
            throw new CancellationException(context+"Class must implement AddSubjectDialogListener()");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("Subject Title: :")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String subjectTitle=editTextSubjectTitle.getText().toString();
                        listener.addNewSubject(subjectTitle);

                    }
                });
        editTextSubjectTitle=view.findViewById(R.id.editTextSubjectTitle);


        return builder.create();
    }

    public interface AddSubjectDialogListener{
        void addNewSubject(String subjectTitle);
    }
}
