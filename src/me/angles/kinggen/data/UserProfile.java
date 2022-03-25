package me.angles.kinggen.data;

import com.google.gson.annotations.SerializedName;

public class UserProfile {
    @SerializedName("username")
    private final String username;

    @SerializedName("generated")
    private int generated;

    @SerializedName("generatedToday")
    private int generatedToday;

    public UserProfile(String username, int generated, int generatedToday) {
        this.username = username;
        this.generated = generated;
        this.generatedToday = generatedToday;
    }

    public String getUsername() {
        return this.username;
    }

    public int getGenerated() {
        return this.generated;
    }

    public int getGeneratedToday() {
        return this.generatedToday;
    }

    public void accountGenerated() { //called when you generate an account
        this.generatedToday++;
        this.generated++;
    }
}
