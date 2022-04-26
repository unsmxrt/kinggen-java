package me.angles.kinggen.exceptions;

import static java.lang.String.format;

public class KingGenException extends RuntimeException {

    public KingGenException(String message) {
        super(format("KingGen returned an error: \"%s\"", message));
    }

    public KingGenException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
