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
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sarahaverill
 */
public class BookingJdbcDAOTest {

    BookingJdbcDAO bookingDao = new BookingJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    PropertyJdbcDAO propertyDao = new PropertyJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    LandlordJdbcDAO landlordDao = new LandlordJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    RenterJdbcDAO renterDao = new RenterJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");

    private Booking booking1;
    private Booking booking2;

    private Landlord landlord1;
    private Landlord landlord2;
    private Property property1;
    private Property property2;
    private Renter renter1;
    private Renter renter2;

    @BeforeEach
    public void setUp() {

        landlord1 = new Landlord();
        landlord1.setLandlordEmail("landordemail1");
        landlord1.setLandlordPassword("landlordpassword1");
        landlord1.setLandlordPhone("0285585589");
        landlord1.setUserName("landlorusername1");

        landlord2 = new Landlord();
        landlord2.setLandlordEmail("landordemail2");
        landlord2.setLandlordPassword("landlordpassword2");
        landlord2.setLandlordPhone("0284685589");
        landlord2.setUserName("landlorusername2");

        landlordDao.saveLandlord(landlord1);
        landlordDao.saveLandlord(landlord2);

        property1 = new Property();
        property1.setAddress("address1");
        property1.setBedrooms(2);
        property1.setLandlordId(landlord1.getLandlordId());
        property1.setStatus("available");

        property2 = new Property();
        property2.setAddress("address2");
        property2.setBedrooms(3);
        property2.setLandlordId(landlord2.getLandlordId());
        property2.setStatus("available");

        propertyDao.saveProperty(property1);
        propertyDao.saveProperty(property2);

        renter1 = new Renter();
        renter1.setReferences("references1");
        renter1.setRenterEmail("renteremail1");
        renter1.setRenterPassword("renterpassword1");
        renter1.setRenterPhone("0265548752");
        renter1.setUserName("renterusername1");
        renter1.setDateOfBirth(new java.sql.Date(1996 - 06 - 06));

        renter2 = new Renter();
        renter2.setReferences("references2");
        renter2.setRenterEmail("renteremail2");
        renter2.setRenterPassword("renterpassword2");
        renter2.setRenterPhone("0265548674");
        renter2.setUserName("renterusername2");
        renter2.setDateOfBirth(new java.sql.Date(1999 - 02 - 06));

        renterDao.saveRenter(renter1);
        renterDao.saveRenter(renter2);

        booking1 = new Booking();
        booking1.setDate(Timestamp.valueOf(LocalDateTime.now()));
        booking1.setLandlordId(landlord1.getLandlordId());
        booking1.setPropertyId(property1.getPropertyId());
        booking1.setRenterId(renter1.getRenterId());
        booking1.setAddress(property1.getAddress());

        booking2 = new Booking();
        booking2.setDate(Timestamp.valueOf(LocalDateTime.now()));
        booking2.setLandlordId(landlord2.getLandlordId());
        booking2.setPropertyId(property2.getPropertyId());
        booking2.setRenterId(renter2.getRenterId());
        booking2.setAddress(property2.getAddress());

        bookingDao.save(booking1);
        //bookingDao.save(booking2);

    }

    @AfterEach
    public void tearDown() {

        bookingDao.removeBooking(booking1);
        bookingDao.removeBooking(booking2);
        renterDao.removeRenter(renter1);
        renterDao.removeRenter(renter2);
        propertyDao.removeProperty(property1);
        propertyDao.removeProperty(property2);
        landlordDao.removeLandlord(landlord1);
        landlordDao.removeLandlord(landlord2);


    }

    @Test
    public void testSave() {
        bookingDao.save(booking2);

        assertThat(bookingDao.getAllBookings(), hasSize(2));

    }



    
    
    
}
