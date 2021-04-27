/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;


import dao.ProperyJdbcDAO;
import domain.Property;

/**
 *
 * @author sarahaverill
 */
public class ProperyJdbcDAOTest {
    
   ProperyJdbcDAO property = new ProperyJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Property property1;
   private Property property2;
   private Property property3;
    
    
    @BeforeEach
    public void setUp() {
     
    }
    
    @AfterEach
    public void save() {
    }
  
    @Test
    public void testFilterByBedroom() {
        
        }
    
     @Test
    public void testGetAllProperties() {
        
        }
    
    @Test
    public void testGetBedrooms() {
        
        }
    
    @Test
    public void testRemoveProperty() {
        
        }
    
     @Test
    public void testSaveProperty() {
        
        }
    
     @Test
    public void testAllowAddToWishList() {
        
        }
    }
  
    
    
