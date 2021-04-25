import Message.Message;
import Titles.Title;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import Message.MessageFactory;
public class Gossips {
    LinkedHashMap<String, Title>gossipsMap;
    List<Message>messages=new ArrayList<>();
    private String talker="";
    private int from_to=0;
    String message="";
    public Gossips(String...gossips){
        gossipsMap=new LinkedHashMap<String,Title>();
        for (String gossip:gossips){
            gossipsMap.put(gossip.split(" ")[1],GossipFactory.getGossip(gossip));
        }
    }
    private Title getByName(String name){
        return this.gossipsMap.get(name);
    }
    public Gossips from(String talker) {
        this.talker=talker;
        switchToFrom();
        return this;
    }
    public Gossips to(String listner) {
        Title title;
        if (from_to==2){
            title=getByName(listner);

            Message msg=title.initMessage(message);
            messages.add(msg);
        }else if(from_to==1){
             title=getByName(talker);
             title.addListner(getByName(listner));
        }


        this.resetTalker();
        this.resetMessage();
        resetSwicher();
        return this;
    }
    public Gossips say(String message){
        this.message=message;
        switchToSay();
        return this;
    }
    public String ask(String gossip){
        return this.getByName(gossip).ask();
    }


    public void spread(){
        MessageFactory.setToReady(messages);
        for(String key : gossipsMap.keySet()){
            Title title=getByName(key);
            title.spread();
            if (!title.continueSpread()) break;
        }
    }

    private void switchToFrom(){
        this.from_to=1;
    }
    private void switchToSay(){
        this.from_to=2;
    }
    private void resetSwicher(){
        this.from_to=0;
    }
    private void resetMessage(){
        this.message="";
    }
    private void resetTalker(){
        this.talker=null;
    }
}
