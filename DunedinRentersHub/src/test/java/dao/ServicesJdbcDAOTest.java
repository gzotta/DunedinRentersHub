/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.security.Provider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sarahaverill
 */
public class ServicesJdbcDAOTest {
    
       ServicesJdbcDAO service = new ServicesJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Provider.Service service1;
   private Provider.Service service2;
   private Provider.Service service3;
    public ServicesJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
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
