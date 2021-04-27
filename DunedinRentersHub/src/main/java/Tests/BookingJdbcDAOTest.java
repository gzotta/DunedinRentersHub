/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import dao.BookingJdbcDAO;
import domain.Booking;

/**
 *
 * @author sarahaverill
 */
public class BookingJdbcDAOTest {
    
   BookingJdbcDAO booking = new BookingJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Booking booking1;
   private Booking booking2;
   private Booking booking3;
    
    
    @BeforeEach
    public void setUp() {
     
    }
    
    @AfterEach
    public void save() {
    }
  
    @Test
    public void testSave() {
        
        }
    
    
    }
  
    
    
