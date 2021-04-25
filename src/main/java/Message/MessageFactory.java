package Message;

import java.util.List;

public class MessageFactory {

    public static Message createMessage(String msg,int spread_say){
        switch (spread_say){
            case 1:return new Message(msg,true);//init message by say
            case 2:return new Message(msg,false);//spread
            default:return null;
        }

    }
    public static List<Message> setToReady(List<Message> messages){
        messages.forEach(message -> message.setToReady());
        return messages;
    }
    public static Message revertMessage(Message msg){

        if (msg!=null){
            StringBuilder sb=new StringBuilder(msg.message);

            msg.message=sb.reverse().toString();
        }
        return msg;
    }
}
