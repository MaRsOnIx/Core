package me.marsonix.core.users.operators;

import me.marsonix.core.users.Level;

import java.math.BigDecimal;
import java.util.UUID;

public class AdminUser extends OperatorUser {

    public AdminUser(String name) {
        super(name);
    }

    public AdminUser(String name, Level level) {
        super(name, level);
    }

    public AdminUser(String name, BigDecimal money) {
        super(name, money);
    }

    public AdminUser( String name, Level level, BigDecimal money) {
        super(name, level, money);
    }


    @Override
    public String specialPrefix() {
        return null;
    }
}
