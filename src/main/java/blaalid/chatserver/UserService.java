
package blaalid.chatserver;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import blaalid.chatserver.UserController.User;

/**
 *
 * @author Blaalid
 */
@Path("user")
@RequestScoped
public class UserService {
    @Inject 
    UserController controller;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<User> getReceiveUsers() {
        return controller.getUsers();
    }
    
}
