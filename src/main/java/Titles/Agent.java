package Titles;

import Message.*;

import java.util.ArrayList;
import java.util.List;

public class Agent extends Title{
    List<Integer>spreededIdx=new ArrayList<>();
    List<Message>messages=new ArrayList<>();
    public Agent(String name) {
        super(name);
    }

    @Override
    public String ask() {
        if (!messages.isEmpty()) return buildMessage();
        return "";
    }

    @Override
    public Message initMessage(String message) {
        Message msg= MessageFactory.createMessage(message,1);
        messages.add(msg);
        return msg;
    }

    String buildMessage(){
        StringBuilder sb=new StringBuilder();
        int index = 0;
        for (int i = 0; i < messages.size(); i++) {

            if(i>0) sb.append(", ");
            sb.append(messages.get(i).getMessage());
        }
        return sb.toString();
    }
    @Override
    boolean canSpread(){
        return true;
    }
    @Override
    void reciveMessage(Message message) {
        message.setToNotReady();
        messages.add(message);
    }

    @Override
    public boolean continueSpread() {
        return true;
    }

    @Override
    Message getMessage() {

        //if(messages.size()>sprededIndex&&messages.get(sprededIndex).ready) return messages.get(sprededIndex);
        return null;

    }
    @Override
    void updateMessage() {
        if (!messages.isEmpty()&&messages.get(0).isReady())  messages.clear();
    }


    @Override
    boolean canListen() {
        return true;
        //return true;
    }
    @Override
    boolean hasReadyMessage() {
        return false;
    }

}
