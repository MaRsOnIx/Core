package me.marsonix.core.system.interfaces;

import me.marsonix.core.users.interfaces.events.Event;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.Map;

public interface LevelsLoadEvent extends Event {
    Map<Integer, BigDecimal> initialized() throws IOException;
}
