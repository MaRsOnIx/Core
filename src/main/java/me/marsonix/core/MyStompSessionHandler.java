package me.marsonix.core;



import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;
public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private StompSession session;

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe("/topic/messages", this);
        this.session=session;
    }


    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        System.out.println("Got an exception " + exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return MessageDTO.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        MessageDTO msg = (MessageDTO) payload;
        System.out.println(msg.getNick() + ": " + msg.getContent());
    }

   public void sendMessage(String message) {
       session.send("/app/chat", new MessageDTO("MaRsOnIx", message));

    }
}