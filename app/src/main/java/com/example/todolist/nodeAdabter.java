package com.example.todolist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class nodeAdabter extends FirebaseRecyclerAdapter<node,nodeAdabter.viewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public nodeAdabter(@NonNull FirebaseRecyclerOptions<node> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull nodeAdabter.viewholder holder, int position, @NonNull node model) {

        holder.title.setText(model.getTitle());
        holder.sub.setText(model.getSub());
    }

    @NonNull
    @Override
    public nodeAdabter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note, parent, false);
        return new nodeAdabter.viewholder(view);


    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView title, sub;
        Button deletbtn;

        FirebaseDatabase database =FirebaseDatabase.getInstance();

        viewholder(View item) {
            super(item);
            deletbtn = item.findViewById(R.id.deletbtn);
            title = item.findViewById(R.id.titlevalue);
            sub = item.findViewById(R.id.subjectvalue);
            deletbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database.getReference(title.getText().toString()).removeValue();
                }

            });
        }
    }
}







