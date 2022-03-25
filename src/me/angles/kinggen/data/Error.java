package me.angles.kinggen.data;

import com.google.gson.annotations.SerializedName;

public class Error {
    @SerializedName("message")
    private String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
