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
import java.util.Date;
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
      
    Landlord land1 = new Landlord(1234, "lpass1", "luse1", "lphone1", "lemail1");
    Property prop1 = new Property(5678, 4321, 3, "add1", "status1");
    Renter rent1 =new Renter(5647, "rpass1", "ruse1", new Date(4/5/2000), "rphone1", "remail1", "rref1");
      
     booking1.setLandlord(land1);
     booking1.setProperty(prop1);
     booking1.setRenter(rent1);
     
    Landlord land2 = new Landlord(1224, "lpass2", "luse2", "lphone2", "lemail2");
    Property prop2 = new Property(5628, 4221, 2, "add2", "status2");
    Renter rent2 =new Renter(5627, "rpass2", "ruse2", new Date(4/2/2000), "rphone2", "remail2", "rref2");
     
     booking2.setLandlord(land2);
     booking2.setProperty(prop2);
     booking2.setRenter(rent2);
     
    Landlord land3 = new Landlord(1334, "lpass3", "luse3", "lphone3", "lemail3");
    Property prop3 = new Property(5378, 4323, 1, "add3", "status3");
    Renter rent3 =new Renter(5347, "rpass3", "ruse3", new Date(4/3/2000), "rphone3", "remail3", "rref3");
    
     booking3.setLandlord(land3);
     booking3.setProperty(prop3);
     booking3.setRenter(rent3);
     
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
