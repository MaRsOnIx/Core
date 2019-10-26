package me.marsonix.core.users.interfaces.events;

public interface Event {

    void setCancelled(boolean cancelled);
    boolean isCancelled();
}
