/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sarahaverill
 */
public class BookingJdbcDAOTest {
    
    BookingJdbcDAO booking = new BookingJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Booking booking1;
   private Booking booking2;
   private Booking booking3;
    
   public BookingJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSave() {
    }
    
}
