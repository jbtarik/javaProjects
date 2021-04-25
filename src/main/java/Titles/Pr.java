package Titles;

import Message.*;

public class Pr extends Title{
    int index_to_spreed_to=0;
    Message message;
    public Pr(String name) {
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
            resetAttemp();
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
    boolean hasMessage(){
        if (this.message == null || !this.message.isReady()) return false;
        return true;
    }
    @Override
    boolean hasReadyMessage() {
        return (this.message!=null && this.message.isReady());
    }
    @Override
    Message getMessage() {
        if (this.message != null && !istSencondAttemp())return null;
        return this.message;
    }

    @Override
    void updateMessage() {
        if (istSencondAttemp()&&this.message!=null)
        {this.message=null;resetAttemp();}
        else incrementAttemp();
    }
    boolean istSencondAttemp(){
        if (index_to_spreed_to == 1) return true;
        return false;
    }
    private void incrementAttemp(){if (this.message!=null)this.index_to_spreed_to++;}
    private void resetAttemp(){this.index_to_spreed_to=0;}
}
