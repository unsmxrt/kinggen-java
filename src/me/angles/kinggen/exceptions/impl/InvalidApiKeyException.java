package me.angles.kinggen.exceptions.impl;

import me.angles.kinggen.exceptions.KingGenException;

public class InvalidApiKeyException extends KingGenException {

    public InvalidApiKeyException() {
        super("Invalid API key provided");
    }

}
