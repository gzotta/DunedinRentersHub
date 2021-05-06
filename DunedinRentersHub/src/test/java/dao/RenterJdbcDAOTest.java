/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Property;
import domain.Renter;
import java.sql.Date;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sarahaverill
 */
public class RenterJdbcDAOTest {
    
   RenterJdbcDAO r = new RenterJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
   
   private Renter r1;
   private Renter r2;
   private Renter r3;
    
    
    public RenterJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
      r1 = new Renter();
      r2 = new Renter();
      r3 = new Renter();
      
      r1.setRenterPassword("Pass1");
      r1.setUserName("User1");
      r1.setDateOfBirth(new Date(2/5/21));
      r1.setRenterPhone("Phone1");
      r1.setRenterEmail("Email1");
      r1.setReferences("Refernce1");
      
      r2.setRenterPassword("Pass2");
      r2.setUserName("User2");
      r2.setDateOfBirth(new Date(2/5/21));
      r2.setRenterPhone("Phone2");
      r2.setRenterEmail("Email2");
      r2.setReferences("Refernce2");
      
      r3.setRenterPassword("Pass3");
      r3.setUserName("User3");
      r3.setDateOfBirth(new Date(2/5/21));
      r3.setRenterPhone("Phone3");
      r3.setRenterEmail("Email3");
      r3.setReferences("Refernce3");
      
      r.saveRenter(r1);
      r.saveRenter(r2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSaveRenter() {
    }

    @Test
    public void testGetRenter() {
     r.getRenter("User1");
     assertThat( r.getRenter("User1"), samePropertyValuesAs(r1, "landlordId"));
    }

    @Test
    public void testGetRenterWishlist() {
    }

    @Test
    public void testValidateCredentials() {
    }
    
}
