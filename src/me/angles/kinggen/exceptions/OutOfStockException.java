package me.angles.kinggen.exceptions;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException() {
        super("Generator is out of stock");
    }

}
