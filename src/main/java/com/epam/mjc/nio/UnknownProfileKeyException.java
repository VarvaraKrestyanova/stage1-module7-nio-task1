package com.epam.mjc.nio;

public class UnknownProfileKeyException extends Exception {

    public UnknownProfileKeyException(String key) {
        super("There is unknown key: " + key);
    }

}
