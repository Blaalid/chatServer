
package blaalid.chatserver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Named
@RequestScoped
public class UserController {
    @Resource(name = "jdbc/sample")
    DataSource ds;
    
    List<User> users;
    
    public List<User> getUsers() {
        if(users == null) {
            users = new ArrayList<>();
            try(
                Connection c = ds.getConnection();
                Statement s = c.createStatement();
            ) {
                ResultSet rs = s.executeQuery("select user_id ,name,phone from user order by name");
                while(rs.next()) {
                    users.add(
                        new User(rs.getInt(1), rs.getString(2), rs.getString(3))
                    );
                }
            } catch(SQLException e) {
                Logger.getLogger(UserController.class.getName()).log(Level.INFO, "message");
            }
        }
        
        return users;
    }
    
    @Data @AllArgsConstructor @NoArgsConstructor
    @XmlRootElement @XmlAccessorType(XmlAccessType.FIELD)
    public static class User implements Serializable {
        long id;
        String name;
        String phone;
    }
}
