package me.angles.kinggen.requests;

public enum Endpoint {
    PROFILE("profile"),
    ACCOUNT("alt");

    private final String name;

    Endpoint(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
