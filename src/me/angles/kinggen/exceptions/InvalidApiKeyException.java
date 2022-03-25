package me.angles.kinggen.exceptions;

public class InvalidApiKeyException extends RuntimeException {

    public InvalidApiKeyException() {
        super("Invalid API key provided");
    }

}
