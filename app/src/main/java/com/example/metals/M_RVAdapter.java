package com.example.metals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class M_RVAdapter extends RecyclerView.Adapter<M_RVAdapter.MyViewHolder> {
    private final RVInterface rvInterface;

    Context context;
    ArrayList<Metals_Model> metalsModels;

    public M_RVAdapter(Context context , ArrayList<Metals_Model> metalsModels, RVInterface rvInterface) {
        this.context = context;
        this.metalsModels = metalsModels;
        this.rvInterface = rvInterface;

    }

    @NonNull
    @Override
    public M_RVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.metals_layout , parent , false );
        return new M_RVAdapter.MyViewHolder(view, rvInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull M_RVAdapter.MyViewHolder holder, int position) {
        holder.metnames.setText(metalsModels.get(position).getMetalName());
        holder.scinames.setText(metalsModels.get(position).getSciName());
        holder.syms.setText(metalsModels.get(position).getSymbol());
        holder.imgs.setImageResource((metalsModels.get(position).getImage()));

    }

    @Override
    public int getItemCount() {
        return metalsModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView metnames , syms, scinames;
        ImageView imgs;

        public MyViewHolder(@NonNull View itemView , RVInterface rvInterface) {
            super(itemView);

            metnames = itemView.findViewById(R.id.textView);
            scinames = itemView.findViewById(R.id.textView1);
            syms = itemView.findViewById(R.id.textView2);
            imgs = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rvInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            rvInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
