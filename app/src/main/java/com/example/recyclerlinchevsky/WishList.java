package com.example.recyclerlinchevsky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WishList extends ArrayAdapter<ListViewItem> {

    private Context context;
    private List<ListViewItem> items;

    public WishList(@NonNull Context context, int resource, @NonNull List<ListViewItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.my_item, parent, false);
        }

        ListViewItem currentItem = items.get(position);

        ImageView imageView = listItem.findViewById(R.id.imageView);
        imageView.setImageResource(currentItem.getImageResource());

        TextView nameTextView = listItem.findViewById(R.id.nameTextView);
        nameTextView.setText(currentItem.getName());

        TextView priceTextView = listItem.findViewById(R.id.priceTextView);
        priceTextView.setText(String.format("$%.2f", currentItem.getPrice()));

        CheckBox checkBox = listItem.findViewById(R.id.checkBox);
        checkBox.setChecked(currentItem.isChecked());
        checkBox.setOnClickListener(view -> {
            currentItem.setChecked(checkBox.isChecked());
            notifyDataSetChanged();
            ((MainActivity) context).ShowPrice();
        });


        return listItem;
    }
}