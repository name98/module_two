package com.example.moduletwo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moduletwo.R;

import java.util.ArrayList;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.Holder> {
    private ArrayList<String> sums;

    public void setSums(ArrayList<String> sums) {
        this.sums = sums;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String sum = sums.get(position);
        holder.setSum(sum);
    }

    @Override
    public int getItemCount() {
        if (sums != null)
            return sums.size();
        return 0;
    }

    static class Holder extends RecyclerView.ViewHolder {
        private TextView sumTextView;

        Holder(@NonNull View itemView) {
            super(itemView);
            sumTextView = itemView.findViewById(R.id.card_item_sum_text_view);
        }

        void setSum(String sum) {
            String sumFormat = sum + " \u20BD";
            sumTextView.setText(sumFormat);
        }
    }
}
