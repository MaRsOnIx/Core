package me.marsonix.core.users.interfaces.events.users;

import me.marsonix.core.users.interfaces.User;
import me.marsonix.core.users.interfaces.events.Event;

import java.io.IOException;

public interface UserLoadEvent extends Event {
    void initialized(User user) throws IOException;

}
