package com.example.moduletwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import com.example.moduletwo.adapters.CardsAdapter;
import com.example.moduletwo.adapters.FavoritesAdapter;
import com.example.moduletwo.adapters.TransfersAdapter;
import com.example.moduletwo.adapters.UsefulAdapter;
import com.example.moduletwo.items.TransferItem;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind(getExampleTransfers(),
                getExampleTransfers(),
                getExampleCards(),
                getExampleUseful());
    }

    private void bind(ArrayList<TransferItem> transfers, ArrayList<TransferItem> favorites, ArrayList<String> sums, ArrayList<TransferItem> useful) {
        RecyclerView transfersRecycleView = findViewById(R.id.activity_main_transfers_recycle_view);
        TransfersAdapter transfersAdapter = new TransfersAdapter();
        transfersAdapter.setTransfers(transfers);
        transfersRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        transfersRecycleView.setAdapter(transfersAdapter);
        SnapHelper snapHelper0 = new PagerSnapHelper();
        snapHelper0.attachToRecyclerView(transfersRecycleView);

        RecyclerView favoritesRecycleView = findViewById(R.id.activity_main_favorites_recycle_view);
        FavoritesAdapter favoritesAdapter = new FavoritesAdapter();
        favoritesAdapter.setFavorites(favorites);
        favoritesRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        favoritesRecycleView.setAdapter(favoritesAdapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(favoritesRecycleView);

        RecyclerView cardsRecycleView = findViewById(R.id.activity_main_cards_recycle_view);
        CardsAdapter cardsAdapter = new CardsAdapter();
        cardsAdapter.setSums(sums);
        cardsRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        cardsRecycleView.setAdapter(cardsAdapter);
        SnapHelper snapHelper1 = new PagerSnapHelper();
        snapHelper1.attachToRecyclerView(cardsRecycleView);

        RecyclerView usefulRecycleView = findViewById(R.id.activity_main_useful_recycle_view);
        UsefulAdapter usefulAdapter = new UsefulAdapter();
        usefulAdapter.setUseful(useful);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        usefulRecycleView.setLayoutManager(manager);
        usefulRecycleView.setAdapter(usefulAdapter);
    }

    private ArrayList<TransferItem> getExampleTransfers() {
        ArrayList<TransferItem> transfers = new ArrayList<>();
        TransferItem transfer = new TransferItem();
        transfer.setLogo(R.drawable.ic_launcher_background);
        transfer.setTitle("На QIWI кошелек");
        for (int i = 0; i < 10; i++) {
            transfers.add(transfer);
        }
        return transfers;
    }

    private ArrayList<String> getExampleCards() {
        ArrayList<String> sums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            String sum = String.valueOf(Math.abs(random.nextInt() % 1000));
            sums.add(sum);
        }
        return sums;
    }

    private ArrayList<TransferItem> getExampleUseful() {
        ArrayList<TransferItem> useful = new ArrayList<>();
        TransferItem item1 = new TransferItem();
        item1.setTitle("Разделение чека");
        item1.setLogo(R.drawable.blank_black);
        TransferItem item2 = new TransferItem();
        item2.setTitle("Счет к оплате");
        item2.setLogo(R.drawable.money_black);
        TransferItem item3 = new TransferItem();
        item3.setTitle("Карта теминалов");
        item3.setLogo(R.drawable.payments_black);
        useful.add(item1);
        useful.add(item2);
        useful.add(item3);
        return useful;
    }
}
