package me.marsonix.core.users.operators;

import me.marsonix.core.users.Level;

import java.math.BigDecimal;

public class SpecialUser extends OperatorUser {

    public SpecialUser(String name) {
        super(name);
    }

    public SpecialUser(String name, Level level) {
        super(name, level);
    }

    public SpecialUser(String name, BigDecimal money) {
        super(name, money);
    }

    public SpecialUser(String name, Level level, BigDecimal money) {
        super(name, level, money);
    }


    @Override
    public String specialPrefix() {
        return null;
    }

}
