package me.marsonix.core.users;

import me.marsonix.core.Core;
import me.marsonix.core.exceptions.CoreNotRunException;
import me.marsonix.core.exceptions.NumberLessThanZeroException;
import me.marsonix.core.exceptions.UserNotFoundException;
import me.marsonix.core.users.interfaces.User;
import me.marsonix.core.users.operators.AdminUser;
import me.marsonix.core.users.operators.ModeratorUser;
import me.marsonix.core.users.operators.SpecialUser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    public void checkGettingRankPositionByLevels() throws CoreNotRunException, UserNotFoundException {
        Core core = new Core();
        List<User>users = Arrays.asList(new AdminUser("MaRsOnIx",new Level(3L)),
                new ModeratorUser( "Pawelos", new Level(4L)),
                new SpecialUser( "Domson", new Level(1L)),
                new DefaultUser( "Jankes", new Level(2L))
        );
        core.getUserList().addAll(users);
        int one = UserManager.getRankPositionByLevels(Optional.of(users.get(0)));
        int two = UserManager.getRankPositionByLevels(Optional.of(users.get(1)));
        int theree = UserManager.getRankPositionByLevels(Optional.of(users.get(2)));
        int four = UserManager.getRankPositionByLevels(Optional.of(users.get(3)));
        assertTrue(one==2 && two==1 && theree==4 && four==3);
    }

    @Test
    public void checkGettingRankPositionByMoney() throws CoreNotRunException, UserNotFoundException, NumberLessThanZeroException {
        Core core = new Core();
        List<User>users = Arrays.asList(new AdminUser("MaRsOnIx"),
                new ModeratorUser("Pawelos"),
                new SpecialUser( "Domson"),
                new DefaultUser( "Jankes")
        );
        users.get(0).addMoney(3);
        users.get(1).addMoney(4);
        users.get(2).addMoney(1);
        users.get(3).addMoney(2);
        core.getUserList().addAll(users);
        int one = UserManager.getRankPositionByMoney(Optional.of(users.get(0)));
        int two = UserManager.getRankPositionByMoney(Optional.of(users.get(1)));
        int theree = UserManager.getRankPositionByMoney(Optional.of(users.get(2)));
        int four = UserManager.getRankPositionByMoney(Optional.of(users.get(3)));
        assertTrue(one==2 && two==1 && theree==4 && four==3);
    }
}