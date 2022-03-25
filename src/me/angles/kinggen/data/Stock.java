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
}
