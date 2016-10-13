package blaalid.chatserver.service;


import blaalid.chatserver.model.Message;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Blaalid
 */
public class MessageService {
    List<Message> mList = new ArrayList<>();
    
    public List<Message> getAllMessages(){
        Message msg1 = new Message(1L, "ja hei du", 1123, "Inge");
        mList.add(msg1);
        return mList;
    }
    
    @GET
    @Path("message/create")
    public Message createMessage(
            @QueryParam("userid") Long userid, 
            @QueryParam("receiver") Long recipientid,
            @QueryParam("text") String text) {
        
        System.out.println("userid: " + userid );
        System.out.println("recipientid: " + recipientid );
        System.out.println("text: " + text );
        Contact sender = em.find(Contact.class, userid);
        Contact recipient = em.find(Contact.class,recipientid);
        if(sender == null)
        {
            System.out.println("SENDER ER NULL");
        }
        if(recipient == null)
        {
            System.out.println("recipient ER NULL");
        }
       
        //TODO: Check for null
        Message message = new Message(sender, recipient, text);
        if((message == null))
        {
             System.out.print("JEG ER NULLLL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
             
        }
     em.persist(message);
       
        
        return message;
    }

  }

