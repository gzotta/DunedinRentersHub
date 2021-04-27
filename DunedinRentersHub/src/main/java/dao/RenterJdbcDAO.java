package dao;


import domain.Property;
import domain.Renter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        String sql = "insert into Renter (renterId, renterPassword, userName, dateOfBirth, renterPhone, renterEmail, references) values (?,?,?,?,?,?,?)";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the renter domain object into the SQL parameters
            stmt.setInt(1, r.getRenterId());
            stmt.setString(2, r.getRenterPassword());
            stmt.setString(3, r.getUsername());
            stmt.setDate(4, (Date) r.getDateOfBirth());
            stmt.setString(5, r.getPhone());
            stmt.setString(6, r.getRenterEmail());
            stmt.setString(7, r.getReferences());

            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    // method to get renter by username
    // support method only - used by validateCredentials() below
    public Renter getRenter(String username) {
        String sql = "select * from Renter where renterUsername = ?";

        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the customer domain object into the SQL parameters
            stmt.setString(1, username);
            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // get the data out of the query
                int renterId1 = rs.getInt("renterId");
                String renterPassword = rs.getString("renterPassword");
                String userName = rs.getString("userName");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String renterPhone = rs.getString("renterPhone");
                String renterEmail = rs.getString("renterEmail");
                String references = rs.getString("references");

                // use the data to create a renter object
                Renter r = new Renter(renterId1, renterPassword, userName, dateOfBirth, renterPhone, renterEmail, references);

                return r;
            } else {
                return null;
            }
        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to return properties filtered by number of bedrooms
    public Collection<Property> getRenterWishlist(Renter r) {

        String sql = "SELECT Poperty.propertyId, Poperty.landlordId, Poperty.bedrooms, Poperty.address, Property.status FROM PROPERTY left outer join WISHLIST ON Property.propertyId = Wishlist.propertyId where Wishlist.RenterId = ?";

        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the product domain object into the SQL parameters
            stmt.setInt(1, r.getRenterId());
            // execute the query
            ResultSet rs = stmt.executeQuery();

            // Using a List to preserve the order in which the data was returned from the query.
            List<Property> properties = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                Integer propertyId = rs.getInt("propertyId");
                Integer landlordId = rs.getInt("landlordId");
                Integer propertyBedrooms = rs.getInt("bedrooms");
                String address = rs.getString("address");
                String status = rs.getString("status");

                // use the data to create a property object
                Property p = new Property();
                p.setPropertyId(propertyId);
                p.setLandlordId(landlordId);
                p.setBedrooms(propertyBedrooms);
                p.setAddress(address);
                p.setStatus(status);

                // and put it in the collection
                properties.add(p);
            }

            //return collection of properties that the renter has on their wishlist
            return properties;

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    // method to sign users in
    // accesses getRenter() above
    public Boolean validateCredentials(String username, String password) {
        Renter r = getRenter(username);
        if ((r != null) && (r.getRenterPassword().equals(password))) {
            return true;
        } else {
            return false;
        }
    }
}
