package com.example.moduletwo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moduletwo.R;
import com.example.moduletwo.items.TransferItem;

import java.util.ArrayList;

public class UsefulAdapter extends RecyclerView.Adapter<UsefulAdapter.Holder> {
    private ArrayList<TransferItem> useful;

    public void setUseful(ArrayList<TransferItem> useful) {
        this.useful = useful;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.useful_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TransferItem useful = this.useful.get(position);
        holder.bind(useful);
    }

    @Override
    public int getItemCount() {
        if (useful != null)
            return useful.size();
        return 0;
    }

    static class Holder extends RecyclerView.ViewHolder {
        private TextView actionTextView;
        private ImageView actionLogoImageView;

        Holder(@NonNull View itemView) {
            super(itemView);
            actionLogoImageView = itemView.findViewById(R.id.useful_item_action_logo_image_view);
            actionTextView = itemView.findViewById(R.id.useful_item_action_text_view);
        }

        void bind(TransferItem usefulItem) {
            actionTextView.setText(usefulItem.getTitle());
            actionLogoImageView.setImageResource(usefulItem.getLogo());
        }

    }
}
