package me.angles.kinggen.exceptions.impl;

import me.angles.kinggen.exceptions.KingGenException;

public class OutOfStockException extends KingGenException {

    public OutOfStockException() {
        super("Generator is out of stock");
    }

}
