package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class addactivity extends AppCompatActivity {

    private EditText title,subject;
    private FirebaseDatabase database ;
    private DatabaseReference ref;
    private Button sendbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addactivity);

        title=findViewById(R.id.sendtitle);
        subject=findViewById(R.id.sendsubject);
        sendbtn=findViewById(R.id.senddtn);
//        final String min =String.valueOf(System.currentTimeMillis());

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addactivity.this,MainActivity.class);
                database= FirebaseDatabase.getInstance();
                 ref = database.getReference(title.getText().toString());
                ref.child("title").setValue(title.getText().toString());
                ref.child("sub").setValue(subject.getText().toString());
                startActivity(intent);

            }
        });

    }
}
