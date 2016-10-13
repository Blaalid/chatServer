package blaalid.chatserver.service;


import blaalid.chatserver.model.Contact;
import blaalid.chatserver.model.Message;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Blaalid
 */
public class MessageService {
    List<Message> mList = new ArrayList<>();
    
    @GET
    @Path("message/create")
    public List<Message> getAllMessages(){
        Message msg1 = new Message(1L, "ja hei du", 1123, "Inge");
        mList.add(msg1);
        return mList;
    }
    
    
    public Message createMessage(
            @QueryParam("userid") Long userid, 
            @QueryParam("receiver") Long recipientid,
            @QueryParam("text") String text) {
        
        System.out.println("userid: " + userid );
        System.out.println("recipientid: " + recipientid );
        System.out.println("text: " + text );
        Contact sender = em.find(Contact.class, userid);
        Contact recipient = em.find(Contact.class, recipientid);
        if(sender == null)
        {
            System.out.println("No sender");
        }
        if(recipient == null)
        {
            System.out.println("No recipient");
        }
       
        //TODO: Check for null
        Message message = new Message(sender, recipient, text);
        if((message == null))
        {
             System.out.print("No message");
             
        }
     em.persist(message);
       
        
        return message;
    }

  }

