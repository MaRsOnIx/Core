package me.marsonix.core.users;

import me.marsonix.core.Core;
import me.marsonix.core.exceptions.CoreNotRunException;
import me.marsonix.core.exceptions.UserNotFoundException;
import me.marsonix.core.users.interfaces.User;
import me.marsonix.core.users.operators.OperatorUser;
import me.marsonix.core.users.operators.Permission;
import me.marsonix.core.utilis.SortingSystem;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserManager {

    public static int getRankPositionByLevels(Optional<User> u) throws CoreNotRunException, UserNotFoundException {
        checkInitializedUser(u);

        List<User> userList = Core.getInstance().getUserList();
        Map<String, Level> dataMap = userList.stream()
                .collect(Collectors.toMap(User::getName, v -> v.getLevel().clone()));

         return getSortedIndexOfUser(u.get().getName(),dataMap);
    }

    public static int getRankPositionByMoney(Optional<User> u) throws CoreNotRunException, UserNotFoundException {
        checkInitializedUser(u);

        List<User> userList = Core.getInstance().getUserList();
        Map<String, BigDecimal> dataMap = userList.stream()
                .collect(Collectors.toMap(User::getName, User::getMoney));
        return getSortedIndexOfUser(u.get().getName(), dataMap);
    }

    private static <T extends Comparable<T>> int getSortedIndexOfUser(String name, Map<String, T> dataMap) throws UserNotFoundException {
        List<Map.Entry<String, T>> entryList = SortingSystem.sortMapByValueAndGetList(dataMap);
        return entryList.size()- IntStream.range(0, entryList.size())
                .filter(v-> entryList.get(v).getKey().equals(name))
                .findFirst().orElseThrow(() -> new UserNotFoundException("The entered name couldn't be find in the list."));
    }

    public static boolean userHasPermission(User u, Permission perm) {
        if(!(u instanceof OperatorUser)) return false;
        OperatorUser op = (OperatorUser) u;
        for(Permission p : op.getPermissions())
            if(p.equals(perm)) return true;

        return false;
    }

    private static void checkInitialized() throws CoreNotRunException {
        if(Core.getInstance()==null) throw new CoreNotRunException("Core have to be runned in order to use this method.");
    }
    private static void checkInitializedUser(Optional<User> u) throws UserNotFoundException, CoreNotRunException {
        checkInitialized();
        if(!u.isPresent()) throw new UserNotFoundException("User have to had any value.");
    }
}
