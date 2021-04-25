package Message;

import Titles.Title;

public  class Message {
    private Title from;
    public Message(String message){
        this.message=message;
        this.ready=false;
        //this.spreeded=false;
    }
    public Message(String message,boolean ready){
        this.message=message;
        this.ready=ready;
        //this.spreeded=false;
    }


    protected String message;
    protected boolean ready;
    boolean spreeded;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReady() {
        return ready;
    }

    public void setToReady() {
        this.ready=true;
    }
    public void setToNotReady() {
        this.ready=false;
    }

    public void setFrom(Title from) {
        this.from = from;
    }

    public Title getFrom() {
        return from;
    }
}
