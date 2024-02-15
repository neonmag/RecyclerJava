package com.example.recyclerlinchevsky;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private List<ListViewItem> wishlistItems;
    private WishList wishList;
    private TextView priceTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        priceTextView = findViewById(R.id.priceTextView);

        wishlistItems = new ArrayList<>();
        wishlistItems.add(new ListViewItem("Micro-cat",R.drawable.cat1, 123));
        wishlistItems.add(new ListViewItem("Very-micro-cat", R.drawable.cat2, 321));
        wishlistItems.add(new ListViewItem("Super-very-micro-cat", R.drawable.cat3, 2312));


        wishList = new WishList(this, R.layout.my_item, wishlistItems);
        listView.setAdapter(wishList);

        ShowPrice();
    }

    void ShowPrice() {
        double totalPrice = wishlistItems.stream()
                .filter(ListViewItem::isChecked)
                .mapToDouble(ListViewItem::getPrice)
                .sum();
        priceTextView.setText(String.format("Total: $%.2f", totalPrice));
    }
}