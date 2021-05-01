/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Landlord;
import java.math.BigDecimal;
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
public class LandlordJdbcDAOTest {
    
    LandlordJdbcDAO l = new LandlordJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
   
   private Landlord l1;
   private Landlord l2;
   private Landlord l3;
    
    public LandlordJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
     l1 = new Landlord();
     l2 = new Landlord();
     l3 = new Landlord();
     l1.setLandlordPassword("Pass1");
     l1.setUserName("User1");
     l1.setLandlordPhone("02102587933");
     l1.setLandlordEmail("l1@gmail.com");
     
     l2.setLandlordPassword("Pass2");
     l2.setUserName("User2");
     l2.setLandlordPhone("02702587933");
     l2.setLandlordEmail("l2@gmail.com");
     
     l3.setLandlordPassword("Pass3");
     l3.setUserName("User3");
     l3.setLandlordPhone("02302587933");
     l3.setLandlordEmail("l3@gmail.com");
     
     l.saveLandlord(l1);
     l.saveLandlord(l2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSaveLandlord() {
     l.saveLandlord(l3);
     
    //  assertThat(l.getLandlord(), hasItem(l1));
     // assertThat(l.getLandlord(), hasItem(l2));
   //  assertThat(l.getLandlord(), hasItem(l3));
    }

    @Test
    public void testGetLandlord() {
   //     assertThat(l.getLandlord(),hasItem(l1) );
   //     assertThat(l.getLandlord(),hasItem(l2) );
    }

    @Test
    public void testValidateCredentials() {
    }
    
}
