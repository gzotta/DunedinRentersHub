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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxer
 */
public class BookingJdbcDAO {

    private final String url = DbConnection.getDefaultConnectionUri();

    //method to save a booking
    public void save(Booking booking) {
        String sqlSaveBookingStmt = "insert into Booking (date, landlordId, propertyId, renterId) values (?,?,?,?)";
        String sqlUpdatePropertyStmt = "UPDATE Property SET status = ? WHERE propertyId = ?";

        Connection con = DbConnection.getConnection(url);

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

                Renter renter = booking.getRenter();
                Property property = booking.getProperty();
                Landlord landlord = booking.getLandlord();

                // #### save the Booking ### //
                // convert booking date into to java.sql.Timestamp
                LocalDateTime date = booking.getDate();
                Timestamp timestamp = Timestamp.valueOf(date);

                // save the booking
                saveBookingStmt.setTimestamp(1, timestamp);
                saveBookingStmt.setInt(2, landlord.getLandlordId());
                saveBookingStmt.setInt(3, property.getPropertyId());
                saveBookingStmt.setInt(4, renter.getRenterId());

                saveBookingStmt.executeUpdate(); //execute the statement

                // get the auto-generated booking ID from the database
                ResultSet rs = saveBookingStmt.getGeneratedKeys();

                Integer bookingId = null;

                if (rs.next()) {
                    bookingId = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated booking ID");
                }

                // ## update the property status ## //
                property.setStatus("booked");
                // updates the property status using the updatePropertyStmt statement.
                updatePropertyStmt.setString(1, property.getStatus());
                updatePropertyStmt.setInt(2, property.getPropertyId());

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
}
