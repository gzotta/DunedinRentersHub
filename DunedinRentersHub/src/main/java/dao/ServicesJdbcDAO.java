package dao;

import domain.Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 *
 * @author jake
 */
public class ServicesJdbcDAO {
 
    private String databaseURI = DbConnection.getDefaultConnectionUri();
 
    // default construcot
    public ServicesJdbcDAO() {
    }
 
    // constructor that intialises the URI
    public ServicesJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }
 
    // method to add service
    public void saveService(Services s) {
        String sql = "insert into Service (serviceType, serviceID, servicePassword, username, servicePhone, serviceEmail) values (?,?,?,?,?,?)";
 
        try (
            // get connection to database
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the service domain object into the SQL parameters
                stmt.setString(1, s.getServiceType());
                stmt.setInt(1, s.getServiceId());
                stmt.setString(2, s.getServicePassword());
                stmt.setString(3, s.getUsername());
                stmt.setString(4, s.getServicePhone());
                stmt.setString(5, s.getServiceEmail());

                stmt.executeUpdate(); // execute the statement
 
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
    }
 
    // method to get service by username
    // support method only - used by validateCredentials() below
    public Services getServices(String serviceId) {
        String sql = "select * from Service where serviceId = ?";
        
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the customer domain object into the SQL parameters
                stmt.setString(1, serviceId);
                // execute the query
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()){
                    // get the data out of the query
                    String serviceType = rs.getString("serviceType");
                    int serviceId1 = rs.getInt("serviceId");
                    String servicePassword  = rs.getString("servicePassword");
                    String username = rs.getString("username");
                    String servicePhone = rs.getString("servicePhone");
                    String serviceEmail = rs.getString("serviceEmail");

                    // use the data to create a service object
                    Services s = new Services(serviceType, serviceId1, servicePassword, username, servicePhone, serviceEmail);

                    return s;
                }
                return null;

            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
    }

    // method to sign users in
    // accesses getService() above
    public Boolean validateCredentials(String username, String password) {
        Services s = getServices(username);
        if ((s != null) && (s.getServicePassword().equals(password))) return true;
        else return false;
    }
}