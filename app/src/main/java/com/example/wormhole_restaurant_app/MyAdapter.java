package com.example.wormhole_restaurant_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<Product> prods;

    public MyAdapter(ArrayList<Product> prods) {
        this.prods = prods;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtName;
        final TextView txtPrice;
        final TextView txtDescription;
        final ImageView ivImg;

        public ViewHolder(View view) {
            super(view);
            txtDescription = (TextView) view.findViewById(R.id.txtDescription);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            ivImg = (ImageView) view.findViewById(R.id.ivImg);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = prods.get(position);
        holder.txtName.setText(p.getName());
        holder.txtPrice.setText("" + p.getPrice());
        holder.txtDescription.setText(p.getDescription());
//        holder.ivImg.setImageResource(p.getImg());
    }

    @Override
    public int getItemCount() {
        return prods.size();
    }
}
