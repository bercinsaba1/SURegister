package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class ClassRecViewAdapter extends RecyclerView.Adapter<ClassRecViewAdapter.ClassViewHolder> {
    List<ClassItem> data;
    Context context;
    public ClassRecViewAdapter(List<ClassItem> data, Context context) {
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.fragment_row,parent,false);
        ClassViewHolder holder = new ClassViewHolder(root);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.txtTitle.setText(data.get(holder.getAdapterPosition()).getTitle());
        String inst = (data.get(holder.getAdapterPosition()).getInstructor());

        holder.txtInstructor.setText(inst);




        holder.row.setOnClickListener(v -> {

            Intent i = new Intent(context,ClassDetailActivity.class);
            i.putExtra("classitem",data.get(holder.getAdapterPosition()));
            ((AppCompatActivity)context).startActivity(i);

        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView txtInstructor;
        TextView txtTitle;
        View row;
        /*
        Handler imgHandler = new Handler(new Handler.Callback(){

            @Override
            public synchronized boolean handleMessage(@NonNull Message msg) {

                imgView.setImageBitmap((Bitmap) msg.obj);
                imageSet = true;

                return true;
            }
        }); */
        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            txtInstructor = itemView.findViewById(R.id.txtInstructor) ;
            txtTitle = itemView.findViewById(R.id.txtTitle);
            row = itemView.findViewById(R.id.containerClass);
        }
    }

    }
