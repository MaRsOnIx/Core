package me.marsonix.core.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.marsonix.core.system.interfaces.LevelsLoadEvent;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public final class LevelInitializing implements LevelsLoadEvent {

    private LevelInitializing(){

    }

    @Override
    public Map<Integer, BigDecimal> initialized() throws IOException {

        String url = "http://pvp.iq.pl/api/";

        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        urlConnection.setRequestMethod("GET");
        ObjectMapper objectMapper = new ObjectMapper();





        return  null;

    }

    @Override
    public void setCancelled(boolean cancelled) {

    }

    @Override
    public boolean isCancelled() {
        return false;
    }
}
