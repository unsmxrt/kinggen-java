package me.angles.kinggen.data;

import com.google.gson.annotations.SerializedName;
import me.angles.kinggen.exceptions.OutOfStockException;

public class Account {
    @SerializedName("email")
    private final String email;

    @SerializedName("password")
    private final String password;

    public Account(String email, String password) {
        if(email == null || email.isEmpty()) throw new OutOfStockException();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
