package com.example.recyclerlinchevsky;

public class ListViewItem {
    private String name;
    private int imageResource;
    private double price;
    private boolean checked;

    public ListViewItem(String name, int imageResource, double price) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
        this.checked = false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
