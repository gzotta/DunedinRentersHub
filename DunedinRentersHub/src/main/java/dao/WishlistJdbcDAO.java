/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Property;
import domain.Renter;
import domain.Wishlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author maxer
 */
public class WishlistJdbcDAO {
    private String databaseURI = DbConnection.getDefaultConnectionUri();

    //default constructor
    public WishlistJdbcDAO() {
    }

    //constructor that intialises the URI
    public WishlistJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }
    
    
    public void addToWishList(Wishlist w) {
        String sql = "insert into Wishlist (renterId, propertyId) values (?,?)";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the renter domain object into the SQL parameters
            stmt.setInt(1, w.getRenter().getRenterId());
            stmt.setInt(2, w.getProperty().getPropertyId());

            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
}
