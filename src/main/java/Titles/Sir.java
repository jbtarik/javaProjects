package Titles;

import Message.Message;
import Message.MessageFactory;
public class Sir extends Title{
    int index_to_spreed_to=0;
    Message message;
    public Sir(String name) {
        super(name);
    }


    @Override
    public String ask() {
        if (this.message!=null) return this.message.getMessage();
        return "";
    }

    @Override
    public Message initMessage(String message) {
        this.message= MessageFactory.createMessage(message,1);
        return this.message;
    }

    @Override
    void reciveMessage(Message message) {
        if (message!=null){
            message.setToNotReady();
            this.message=message;
            //le listner de Titles.Sir devient le gossip qui lui a transmit un message
            this.listner=message.getFrom();
        }

    }

    @Override
    public boolean continueSpread() {
        if(this.message!=null && !this.message.isReady()) return false;
        return true;
    }


    @Override
    boolean canListen() {
        return (message==null || listner==null);
    }

    @Override
    Message getMessage() {
        this.message= MessageFactory.revertMessage(this.message);
        return this.message;
    }

    @Override
    boolean hasReadyMessage() {
        return (this.message!=null && this.message.isReady());
    }

    @Override
    void updateMessage() {
        this.message=null;
    }

}
