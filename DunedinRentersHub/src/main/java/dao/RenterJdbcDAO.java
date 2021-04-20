package dao;

import domain.Renter;
import domain.Property;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 *
 * @author jake
 */
public class RenterJdbcDAO {
 
    private String databaseURI = DbConnection.getDefaultConnectionUri();
 
    // default construcot
    public RenterJdbcDAO() {
    }
 
    // constructor that intialises the URI
    public RenterJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }
 
    // method to add renter
    public void saveRenter(Renter r) {
        String sql = "insert into Renter (renterId, renterPassword, userName, dateOfBirth, renterPhone, renterEmail, references, wishList) values (?,?,?,?,?,?,?,?)";
 
        try (
            // get connection to database
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the renter domain object into the SQL parameters
                stmt.setInt(1, r.getRenterId());
                stmt.setString(2, r.getRenterPassword());
                stmt.setString(3, r.getUsername());
                stmt.setDate(4, r.getDateOfBirth());
                stmt.setString(5, r.getPhone());
                stmt.setString(6, r.getRenterEmail());
                stmt.setString(7, r.getReferences());
                stmt.setString(8, r.getWishlist(i));

                stmt.executeUpdate(); // execute the statement
 
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
    }
 
    // method to get renter by id
    // support method only - used by validateCredentials() below
    public Renter getRenter(int givenId) {
        String sql = "select * from Renter where renterId = ?";
        
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(url);
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the customer domain object into the SQL parameters
                stmt.setInt(1, givenId);
                // execute the query
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()){
                    // get the data out of the query
                    int renterId = rs.getInt("renterId");
                    String renterPassword  = rs.getString("renterPassword");
                    String userName = rs.getString("userName");
                    Date dateOfBirth = rs.getDate("dateOfBirth");
                    String renterPhone = rs.getString("renterPhone");
                    String renterEmail = rs.getString("renterEmail");
                    String references = rs.getString("references");
                    ArrayList<Property> wishList = rs.getString("wishList");

                    // use the data to create a renter object
                    Renter r = new Renter(renterId, renterPassword, userName, dateOfBirth, renterPhone, renterEmail, references, wishList);

                    return r;
                }
                return null;

            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
    }

    // method to sign users in
    // accesses getRenter() above
    public Boolean validateCredentials(String username, String password) {
        Renter r = getRenter(username);
        if ((r != null) && (r.getPassword().equals(password))) return true;
        else return false;
    }
}