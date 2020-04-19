package com.example.isupportlockdown;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

 public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context ctx;
    String data[];
    String data2[],data3[];

    public MyAdapter(Context ct, String[] i1, String[] s1, String[] s2){
        ctx = ct;
        data = i1;
        data2 = s1;
        data3 = s2;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myinflater = LayoutInflater.from(ctx);
        View myView = myinflater.inflate(R.layout.my_row,parent,false);
        return new MyHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.t1.setText(data[position]);
        holder.t2.setText(data2[position]);
        holder.t3.setText(data3[position]);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView t1;
        EditText t2,t3;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.t1);
            t2 = (EditText) itemView.findViewById(R.id.t2);
            t3 = (EditText) itemView.findViewById(R.id.t3);

        }
    }


}
