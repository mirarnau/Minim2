package edu.upc.dsa.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import edu.upc.dsa.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<Object> data;
    Context context;

    public RecyclerAdapter(Context context, List<Object> data){
        this.data = data;
        this.context = context;
    }

    //To create the views.
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_entry,parent,false);
        return new ViewHolder(view);
    }

    //To insert data into the views.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {




        /*
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            //This is the code so that when a particular track is clicked, its information appears in the new layout.
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoPlane.class);
                intent.putExtra("MODEL", model);
                context.startActivity(intent);
            }
        });

         */

    }

    //Creates the number of views.
    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleID);
            subtitle = itemView.findViewById(R.id.subtitleID);


        }
    }
}
