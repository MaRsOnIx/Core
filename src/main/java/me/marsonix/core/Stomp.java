package me.marsonix.core;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

// Testing web sockets

public class Stomp {
    private static String URL = "ws://pvp.iq.pl:8080/chat";

    public static void main(String[] args) {
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        MyStompSessionHandler sessionHandler = new MyStompSessionHandler();
        stompClient.connect(URL, sessionHandler);
        Scanner sc;
        while(true) {
            sc = new Scanner(System.in);
           sessionHandler.sendMessage( sc.nextLine());
        }
    }

}
