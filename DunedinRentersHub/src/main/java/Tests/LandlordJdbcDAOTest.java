/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import dao.LandlordJdbcDAO;
import domain.Booking;
import domain.Landlord;

/**
 *
 * @author sarahaverill
 */
public class LandlordJdbcDAOTest {
    
LandlordJdbcDAO landlord = new LandlordJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Landlord landlord1;
   private Landlord landlord2;
   private Landlord landlord3;
    
    
    @BeforeEach
    public void setUp() {
     
    }
    
    @AfterEach
    public void save() {
    }
  
    @Test
    public void testSaveLandlord() {
        
        }
    
     @Test
    public void testGetLandlord() {
        
        }
    
     @Test
    public void testValidateCredentials() {
        
        }
    
     
    }
  