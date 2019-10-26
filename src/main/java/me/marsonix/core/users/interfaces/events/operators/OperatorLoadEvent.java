package me.marsonix.core.users.interfaces.events.operators;

import me.marsonix.core.users.interfaces.events.Event;
import me.marsonix.core.users.operators.OperatorUser;

public interface OperatorLoadEvent extends Event {

    void initialized(OperatorUser user);

}
