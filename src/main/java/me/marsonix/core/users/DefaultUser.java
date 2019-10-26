package me.marsonix.core.users;

import me.marsonix.core.exceptions.NumberLessThanZeroException;
import me.marsonix.core.users.interfaces.User;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

public class DefaultUser implements User {

    private String name;
    private Level level;
    private BigDecimal money;

    public DefaultUser(String name) {
        this(name, new Level(0L), new BigDecimal(0L));
    }

    public DefaultUser(String name, Level level) {
        this(name, level, new BigDecimal(0L));
    }
    public DefaultUser(String name, BigDecimal money) {
        this(name, new Level(0L), money);
    }

    public DefaultUser(String name, Level level, BigDecimal money) {
        this.name = name;
        this.level = level;
        this.money=money;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public BigDecimal getMoney() {
        return this.money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUser that = (DefaultUser) o;
        return name.equals(that.name) &&
                level.equals(that.level) &&
                money.equals(that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, money);
    }

    @Override
    public String toString() {
        return "DefaultUser{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", money=" + money +
                '}';
    }

    @Override
    public void addMoney(double amount) throws NumberLessThanZeroException {
        checkNumberLessThanZero(amount);

        this.money=this.money.add(BigDecimal.valueOf(amount));
    }

    @Override
    public void addMoney(long amount) throws NumberLessThanZeroException {
        checkNumberLessThanZero(amount);
        this.money=this.money.add(BigDecimal.valueOf(amount));
    }
    @Override
    public void removeMoney(double amount) throws NumberLessThanZeroException {
        checkNumberLessThanZero(amount);
        this.money=this.money.subtract(BigDecimal.valueOf(amount));
    }
    @Override
    public void removeMoney(long amount) throws NumberLessThanZeroException {
        checkNumberLessThanZero(amount);
        this.money=this.money.subtract(BigDecimal.valueOf(amount));
    }
    private void checkNumberLessThanZero(Number amount) throws NumberLessThanZeroException {
        if (amount.doubleValue() < 0) throw new NumberLessThanZeroException("Entered value have to be greater than 0");
    }

    public void load() throws IOException {
        UserInitializing.run(this);
    }

//    public void load(UserLoadEvent event) {
//        event.setUser(this);
//    }


}
