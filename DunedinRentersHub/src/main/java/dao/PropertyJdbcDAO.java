/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Property;
import domain.Renter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author maxer
 */
public class PropertyJdbcDAO {

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    //default constructor
    public PropertyJdbcDAO() {
    }

    //constructor that intialises the URI
    public PropertyJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    //method to return properties filtered by number of bedrooms
    public Collection<Property> filterByBedroom(Integer bedrooms) {

        String sql = "select * from Property where bedrooms = ? order by propertyId";

        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the property domain object into the SQL parameters
            stmt.setInt(1, bedrooms);
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

            //return collection of properties that has been filtered by number of bedrooms
            return properties;

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to return all properteis
    public Collection<Property> getAllProperties() {
        String sql = "select * from Property order by propertyId";

        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // execute the query
            ResultSet rs = stmt.executeQuery();

            // Using a List to preserve the order in which the data was returned from the query.
            List<Property> properties = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                Integer propertyId = rs.getInt("propertyId");
                Integer landlordId = rs.getInt("landlordId");
                Integer bedrooms = rs.getInt("bedrooms");
                String address = rs.getString("address");
                String status = rs.getString("status");

                // use the data to create a property object
                Property p = new Property();
                p.setPropertyId(propertyId);
                p.setLandlordId(landlordId);
                p.setBedrooms(bedrooms);
                p.setAddress(address);
                p.setStatus(status);

                // and put it in the collection
                properties.add(p);
            }

            return properties;

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to return property by ID.
    public Property getPropertyById(Integer id) {
        String sql = "select * from Property where propertyId = ?";

        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            //copy the data from the property domain object into the SQL parameters
            stmt.setInt(1, id);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            // Create the Property object.
            //Property property = new Property();
            // iterate through the query results
            if (rs.next()) {

                // get the data out of the query
                Integer propertyId = rs.getInt("propertyId");
                Integer landlordId = rs.getInt("landlordId");
                Integer bedrooms = rs.getInt("bedrooms");
                String address = rs.getString("address");
                String status = rs.getString("status");

                // use the data to create a property object
                Property property = new Property();
                property.setPropertyId(propertyId);
                property.setLandlordId(landlordId);
                property.setBedrooms(bedrooms);
                property.setAddress(address);
                property.setStatus(status);

                return property;
            } else {
                return null;
            }
        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to return all properties filtered by bedrooms
    public Collection<Integer> getBedrooms() {
        String sql = "select distinct bedrooms from Property";

        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // execute the query
            ResultSet rs = stmt.executeQuery();

            // Using a List to preserve the order in which the data was returned from the query.
            List<Integer> bedrooms = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {
                //add the number of bedrooms to the collection
                bedrooms.add(rs.getInt("bedrooms"));
            }

            return bedrooms;

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to delete a property listing
    public void removeProperty(Property p) {
        String sql = "delete Property where propertyId = ?";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the property domain object into the SQL parameters
            stmt.setInt(1, p.getPropertyId());

            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to add a property
    public void saveProperty(Property p) {
        String sql = "insert into Property (propertyId, landlordId, bedrooms, address, status) values (?,?,?,?,?)";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the property domain object into the SQL parameters
      
            stmt.setInt(1, p.getPropertyId());
            stmt.setInt(2, p.getLandlordId());
            stmt.setInt(3, p.getBedrooms());
            stmt.setString(4, p.getAddress());
            stmt.setString(5, p.getStatus());

            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to add a property to a renters wishlist
    public void addToWishList(Renter r, Property p) {
        String sql = "insert into Wishlist (renterId, propertyId) values (?,?)";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the renter domain object into the SQL parameters
            stmt.setInt(1, r.getRenterId());
            stmt.setInt(2, p.getPropertyId());

            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}
