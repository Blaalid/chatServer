package blaalid.chatserver.resource;

import blaalid.chatserver.model.Message;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import blaalid.chatserver.service.MessageService;
import java.util.List;
import javax.ws.rs.Path;

/**
 *
 * @author Blaalid
 */
@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }
}
