package me.marsonix.core.users.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.marsonix.core.exceptions.CoreNotRunException;
import me.marsonix.core.exceptions.NumberLessThanZeroException;
import me.marsonix.core.exceptions.UserNotFoundException;
import me.marsonix.core.users.Level;
import me.marsonix.core.users.UserManager;
import me.marsonix.core.users.operators.Permission;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

public interface User {

    String getName();
    Level getLevel();
    void setLevel(Level level);
    BigDecimal getMoney();
    void addMoney(double amount) throws NumberLessThanZeroException;
    void addMoney(long amount) throws NumberLessThanZeroException;
    void removeMoney(double amount) throws NumberLessThanZeroException;
    void removeMoney(long amount) throws NumberLessThanZeroException;
    void load() throws IOException;


    @JsonIgnore
    default int getRankPositionByLevel() throws CoreNotRunException, UserNotFoundException {
        return UserManager.getRankPositionByLevels(Optional.of(this));
    }
    default boolean hasPermission(Permission perm)  {
        return UserManager.userHasPermission(this, perm);
    }

}
