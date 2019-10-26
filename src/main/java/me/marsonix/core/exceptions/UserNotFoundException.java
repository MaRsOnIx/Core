package me.marsonix.core.exceptions;

import java.util.function.Supplier;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String error) {
        super(error);
    }
}
