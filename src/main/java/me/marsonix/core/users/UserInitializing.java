package me.marsonix.core.users;


import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import me.marsonix.core.users.interfaces.User;
import me.marsonix.core.users.interfaces.events.users.UserLoadEvent;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

public final class UserInitializing implements UserLoadEvent {

    final private User user;

    private UserInitializing(final User user) throws IOException {
        this.user=user;
        initialized(user);
    }

    public static void run(final User user) throws IOException {
        if(true) {
            ObjectMapper maper = new ObjectMapper();
            User u = new DefaultUser("MaRsOnIx");
           // System.out.println(maper.writeValueAsString(u));
            maper.writeValue(new File("test.txt"), u);
            return;
        }
        new UserInitializing(user);
    }

    @Override
    public void initialized(User user) throws IOException {

        URL url = new URL("http://pvp.iq.pl:8080/api/users/0");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
       Scanner sc = new Scanner(connection.getInputStream());
       while(sc.hasNext()){
           System.out.println(sc.nextLine());
       }
    }

    public static void main(String[] args) throws IOException {
        run(null);
    }

    @Override
    public void setCancelled(boolean cancelled) {

    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    public User getUser() {
        return user;
    }

}
