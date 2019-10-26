package me.marsonix.core.users.operators;

import me.marsonix.core.users.Level;

import java.math.BigDecimal;

public class ModeratorUser extends OperatorUser {

    public ModeratorUser(String name) {
        super(name);
    }

    public ModeratorUser(String name, Level level) {
        super(name, level);
    }

    public ModeratorUser(String name, BigDecimal money) {
        super(name, money);
    }

    public ModeratorUser(String name, Level level, BigDecimal money) {
        super(name, level, money);
    }

    @Override
    public String specialPrefix() {
        return null;
    }
}
