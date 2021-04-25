package Titles;

import Message.*;

public class Lady extends Title{
    int index_to_spreed_to=0;
    Message message;
    public Lady(String name) {
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
        return this.message;
    }

    @Override
    boolean hasReadyMessage() {
        boolean isdr = this.message!=null?this.message.getFrom() instanceof  Dr:false;
        return (this.message!=null && this.message.isReady() && this.message.getFrom() instanceof  Dr);
    }

    @Override
    void updateMessage() {
        this.message=null;
    }

}
