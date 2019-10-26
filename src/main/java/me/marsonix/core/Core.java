package me.marsonix.core;

import me.marsonix.core.users.interfaces.User;

import java.util.ArrayList;
import java.util.List;

public class Core {

    private List<User> userList;
    private static Core instance;
    public static void main(String[] args) {

        new Core();


    }

    public Core(){
        this.userList =new ArrayList<>();
        instance=this;

    }

    public List<User> getUserList() {
        return userList;
    }

    public static Core getInstance() {
        return instance;
    }
}
