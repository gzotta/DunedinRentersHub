/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Booking;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sarahaverill
 */
public class BookingJdbcDAOTest {
    
    BookingJdbcDAO booking = new BookingJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
   
   private Booking booking1;
   private Booking booking2;
   private Booking booking3;
    
   public BookingJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
      booking1 = new Booking();
      booking2 = new Booking();
      booking3 = new Booking();
      
     // booking1.setLandlordId(5678);
     // booking1.setPropertyId(5658);
     // booking1.setRenterId(7654);
     
     // booking2.setLandlordId(5673);
     // booking2.setPropertyId(5672);
     // booking2.setRenterId(7054);
      
     // booking3.setLandlordId(6678);
     // booking3.setPropertyId(5378);
    //  booking3.setRenterId(7684);
      
     booking.save(booking1);
     booking.save(booking2);    
         
    }
    
    @AfterEach
    public void tearDown() {
       
    }

    @Test
    public void testSave() {
      booking.save(booking3);
    //  assertThat(booking.getBookings(), hasSize(3));
    //  assertThat(booking.getBookings(), hasItem(booking1));
    //  assertThat(booking.getBookings(), hasItem(booking2));
   //  assertThat(booking.getBookings(), hasItem(booking3));
    }
    
}
