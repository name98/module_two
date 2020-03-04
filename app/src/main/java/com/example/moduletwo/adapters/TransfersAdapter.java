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

public class TransfersAdapter extends RecyclerView.Adapter<TransfersAdapter.Holder> {
    private ArrayList<TransferItem> transfers;

    public void setTransfers(ArrayList<TransferItem> transfers) {
        this.transfers = transfers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transfers_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TransferItem transfer = transfers.get(position);
        holder.bind(transfer);
    }

    @Override
    public int getItemCount() {
        if (transfers != null)
            return transfers.size();
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder {
        private ImageView actionLogoImageView;
        private TextView actionTitleTextView;

        Holder(@NonNull View itemView) {
            super(itemView);
            actionLogoImageView = itemView.findViewById(R.id.transfer_item_logo_image_view);
            actionTitleTextView = itemView.findViewById(R.id.transfer_item_title_text_view);
        }

        void bind(TransferItem transfer) {
            actionTitleTextView.setText(transfer.getTitle());
            actionLogoImageView.setImageResource(transfer.getLogo());
        }
    }
}
