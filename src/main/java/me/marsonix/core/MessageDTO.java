package me.marsonix.core;

public class MessageDTO {

    private String nick;
    private String content;

    public MessageDTO(){

    }

    public MessageDTO(String nick, String content) {
        this.nick = nick;
        this.content = content;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
