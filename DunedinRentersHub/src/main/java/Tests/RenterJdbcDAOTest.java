/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import dao.RenterJdbcDAO;
import domain.Renter;



/**
 *
 * @author sarahaverill
 */
public class RenterJdbcDAOTest {
    
   RenterJdbcDAO renter = new RenterJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Renter renter1;
   private Renter renter2;
   private Renter renter3;
    
    
    @BeforeEach
    public void setUp() {
     
    }
    
    @AfterEach
    public void save() {
    }
  
    @Test
    public void testSaveRenter() {
        
        }
    
      @Test
    public void testGetRenter() {
        
        }
    
     @Test
    public void testGetRenterWishlist() {
        
        }
    
     @Test
    public void testValidateCredentials() {
        
        }
    }
  
    
    
