/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import dao.ServicesJdbcDAO;
import java.security.Provider.Service;

/**
 *
 * @author sarahaverill
 */
public class ServicesJdbcDAOTest {
    
   ServicesJdbcDAO service = new ServicesJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Service service1;
   private Service service2;
   private Service service3;
    
    
    @BeforeEach
    public void setUp() {
     
    }
    
    @AfterEach
    public void save() {
    }
  
    @Test
    public void testSaveService() {
        
        }
    
    @Test
    public void testGetServices() {
        
        }
    
    @Test
    public void testFilterByType() {
        
        }
    
     @Test
    public void testValidateCredentials() {
        
        }
    
    }
  
    
    
