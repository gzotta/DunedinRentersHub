/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Booking;
import domain.Landlord;
import domain.Property;
import domain.Renter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.expression.function.ToDateParser;

/**
 *
 * @author maxer
 */
public class BookingJdbcDAO {

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    // default construcot
    public BookingJdbcDAO() {
    }

    // constructor that intialises the URI
    public BookingJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    //method to save a booking
    public void save(Booking booking) {
        String sqlSaveBookingStmt = "insert into Booking (date, landlordId, propertyId, renterId, address) values (?,?,?,?,?)";
        String sqlUpdatePropertyStmt = "UPDATE Property SET status = ? WHERE propertyId = ?";

        Connection con = DbConnection.getConnection(databaseURI);

        try {
            try (
                    PreparedStatement saveBookingStmt = con.prepareStatement(
                            sqlSaveBookingStmt, Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement updatePropertyStmt = con.prepareStatement(
                            sqlUpdatePropertyStmt);) {

                // Since saving a Bookinginvolves multiple statements across
                // multiple tables we need to control the transaction ourselves
                // to ensure the DB remains consistent.  Turning off auto-commit
                // effectively starts a new transaction.
                con.setAutoCommit(false);

//                Property property = booking.getProperty();
//                Renter renter = booking.getRenter();
//                Landlord landlord = booking.getLandlord();

                // #### save the Booking ### //
                // convert booking date into to java.sql.Timestamp
//                LocalDateTime date = booking.getDate();
//                Timestamp timestamp = Timestamp.valueOf(date);

                // save the booking
                saveBookingStmt.setTimestamp(1, booking.getDate());
                saveBookingStmt.setInt(2, booking.getLandlordId());
                saveBookingStmt.setInt(3, booking.getPropertyId());
                saveBookingStmt.setInt(4, booking.getRenterId());
                saveBookingStmt.setString(5, booking.getAddress());
                

                saveBookingStmt.executeUpdate(); //execute the statement

                // get the auto-generated booking ID from the database
                ResultSet rs = saveBookingStmt.getGeneratedKeys();

                Integer bookingId = null;

                if (rs.next()) {
                    bookingId = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated booking ID");
                }
                booking.setBookingId(bookingId);

                // ## update the property status ## //
                String status = "booked";
                // updates the property status using the updatePropertyStmt statement.
                updatePropertyStmt.setString(1, status);
                updatePropertyStmt.setInt(2, booking.getPropertyId());

                updatePropertyStmt.executeUpdate(); // execute the statement

                // commit the transaction
                con.setAutoCommit(true);
            }
        } catch (SQLException ex) {

            Logger.getLogger(BookingJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);

            try {
                // something went wrong so rollback
                con.rollback();

                // turn auto-commit back on
                con.setAutoCommit(true);

                // and throw an exception to tell the user something bad happened
                throw new DAOException(ex.getMessage(), ex);
            } catch (SQLException ex1) {
                throw new DAOException(ex1.getMessage(), ex1);
            }

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookingJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void removeBooking(Booking booking) {
        String sql = "delete Booking where bookingId = ?";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the property domain object into the SQL parameters
            stmt.setInt(1, booking.getBookingId());

            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    //method to return all bookings. Just for testing.
    public Collection<Integer> getAllBookings() {
        String sql = "select * from Booking order by bookingId";

        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // execute the query
            ResultSet rs = stmt.executeQuery();

            // Using a List to preserve the order in which the data was returned from the query.
            List<Integer> bookings = new ArrayList<>();

            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                Integer bookingId = rs.getInt("bookingId");

                // and put it in the collection
                bookings.add(bookingId);
            }

            return bookings;

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    //method to return all bookings for a renter
    public Collection<Booking> getRenterBookings(Integer renterId) {
        String sql = "select * from Booking where renterId = ?";

        
        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the property domain object into the SQL parameters
            stmt.setInt(1, renterId);

            ResultSet rs = stmt.executeQuery();
            
            List<Booking> bookings = new ArrayList<>();
            
            // iterate through the query results
            while (rs.next()) {

                // get the data out of the query
                Integer BookingId = rs.getInt("bookingId");
                Timestamp date = rs.getTimestamp("date");
                Integer landlordId = rs.getInt("landlordId");
                Integer propertyId = rs.getInt("propertyId");
                Integer renterId1 = rs.getInt("renterId");
                String address = rs.getString("address");

                // use the data to create a property object
                Booking b = new Booking();
                b.setBookingId(BookingId);
                b.setDate(date);
                b.setLandlordId(landlordId);
                b.setPropertyId(propertyId);
                b.setRenterId(renterId1);
                b.setAddress(address);

                // and put it in the collection
                bookings.add(b);
            }
            
            return bookings;

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}
