package me.marsonix.core.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.marsonix.core.exceptions.CoreNotRunException;
import me.marsonix.core.exceptions.NumberLessThanZeroException;
import me.marsonix.core.exceptions.UserNotFoundException;
import me.marsonix.core.users.interfaces.User;
import me.marsonix.core.users.operators.OperatorUser;
import me.marsonix.core.users.operators.Permission;
import me.marsonix.core.users.operators.SpecialUser;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void checkNotInitializedPlayerArray() {
        User user = new DefaultUser("MaRsOnIx", new Level(1000L));
        assertThrows(CoreNotRunException.class, ()-> UserManager.getRankPositionByLevels(Optional.of(user)));
    }

    @Test
    public void checkSpecialUserDoesntHaveAnyPermission() throws UserNotFoundException {
        OperatorUser operatorUser = new SpecialUser("MaRsOnIx", new Level(100L));
        assertFalse(operatorUser.hasPermission(Permission.BUILDING));
    }

    @Test
    public void checkAddingMoney() throws NumberLessThanZeroException {
        User user = new DefaultUser("MaRsOnIx",new BigDecimal(3));
        user.addMoney(5.5);
        assertTrue(user.getMoney().doubleValue()==8.5);
    }
    @Test
    public void testJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new DefaultUser("test");
        String s =objectMapper.writeValueAsString(user);
        System.out.println(s);
    }



}