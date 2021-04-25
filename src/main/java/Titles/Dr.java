package Titles;

import Message.*;

import java.util.ArrayList;
import java.util.List;

public class Dr extends Title{
    List<Integer>spreededIdx=new ArrayList<>();
    List<Message>messages=new ArrayList<>();
    public Dr(String name) {
        super(name);
    }

    @Override
    public String ask() {
        if (!messages.isEmpty()) return buildMessage();
        return "";
    }

    @Override
    public Message initMessage(String message) {
        Message msg=MessageFactory.createMessage(message,1);
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
    void reciveMessage(Message message) {
        if (message!=null){
            message.setToNotReady();
            messages.add(message);
        }

    }

    @Override
    public boolean continueSpread() {
        return true;
    }

    @Override
    Message getMessage() {
        if(messages.size()>sprededIndex&&messages.get(sprededIndex).isReady()) return messages.get(sprededIndex);
        return null;

    }
private int sprededIndex=0;
    @Override
    void updateMessage() {
        sprededIndex++;
    }


    @Override
    boolean canListen() {
        if (messages.isEmpty())return true;
        return messages.get(messages.size()-1).isReady();
        //return true;
    }
    @Override
    boolean hasReadyMessage() {
        return (getMessage()!=null && getMessage().isReady());
    }

}
