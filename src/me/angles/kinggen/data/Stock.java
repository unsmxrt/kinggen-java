package me.angles.kinggen.data;

import com.google.gson.annotations.SerializedName;

public class Stock {
    @SerializedName("stock")
    private int amount;

    public Stock(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() { //so that you don't have to always call getStock()
        return String.valueOf(amount);
    }
}
