/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Landlord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author sarahaverill
 */
public class LandlordJdbcDAOTest {
    
    LandlordJdbcDAO landlord = new LandlordJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Landlord landlord1;
   private Landlord landlord2;
   private Landlord landlord3;
    
    public LandlordJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
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
