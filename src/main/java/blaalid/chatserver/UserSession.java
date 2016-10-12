package blaalid.chatserver;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("myservice")
public class UserSession {
    @PersistenceContext
    EntityManager em;
    
    @GET
    public List<User> getAllUsers() {
        return em.createQuery("SELECT c from User c").getResultList();
    }
    
    public boolean createUser(User user) {
        em.persist(user);
        return true;
    }
}