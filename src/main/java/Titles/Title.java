package Titles;

import Message.Message;

public abstract class Title {
    private final String name;
    Title listner;

    protected Title(String name) {
        this.name = name;
    }

    public void addListner(Title listner){
        this.listner=listner;
    }
    boolean hasListner(){
        if (listner!=null) return true;
        return false;
    }
    boolean hasMessage(){
        if (getMessage()==null) return false;
        return true;
    }
    public abstract String ask();
    public abstract Message initMessage(String message);
    abstract boolean canListen();
    abstract Message getMessage();
    abstract boolean hasReadyMessage();
    //updateMessage() cette fonction doit signaler que le message getMessage à été transmis surtt pour le DR
    // et que le message n'est plus ready
    abstract void updateMessage();
    abstract void reciveMessage(Message msg);
    boolean canSpread(){
        if (hasListner() && listner.canListen() && hasReadyMessage()) return true;
        return false;
    }
    public abstract boolean continueSpread();
    public void spread(){
        if (canSpread()){
            Message msg=getMessage();
            if (msg!=null) {
                msg.setFrom(this);
                listner.reciveMessage(msg);
            }
            updateMessage();

        }
    }
}
