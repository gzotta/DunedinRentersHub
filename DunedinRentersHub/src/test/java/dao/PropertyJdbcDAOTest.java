/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Property;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author sarahaverill
 */
public class PropertyJdbcDAOTest {
    
    PropertyJdbcDAO p = new PropertyJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
   
   private Property p1;
   private Property p2;
   private Property p3;
    
    public PropertyJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
      p1 = new Property();
      p2 = new Property();
      p3 = new Property();
      
      p1.setBedrooms(1);
      p1.setLandlordId(1234);
      p1.setAddress("A1");
      p1.setStatus("D1");
    
      p2.setBedrooms(3);
      p2.setLandlordId(1235);
      p2.setAddress("A2");
      p2.setStatus("D2");
      
      p3.setBedrooms(3);
      p3.setLandlordId(1235);
      p3.setAddress("A2");
      p3.setStatus("D2");
      
      p.saveProperty(p1);
      p.saveProperty(p2);
        
    }
    
    @AfterEach
    public void tearDown() {
        p.removeProperty(p1);
        p.removeProperty(p2);
    }

    @Test
    public void testFilterByBedroom() {
       assertThat(p.filterByBedroom(p1.getBedrooms()), hasItem(p1));
       assertThat(p.filterByBedroom(p1.getBedrooms()), not(hasItem(p2)));
    }

    @Test
    public void testGetAllProperties() {
        assertThat(p.getAllProperties(),hasItem(p1) );
        assertThat(p.getAllProperties(),hasItem(p2) );
    }

    @Test
    public void testGetBedrooms() {
        assertThat(p.getBedrooms(), hasItem(p1.getBedrooms()));
        assertThat(p.getBedrooms(), hasItem(p2.getBedrooms()));
    }

    @Test
    public void testRemoveProperty() {
      p.removeProperty(p1);
      assertThat(p.getAllProperties(), hasSize(1));
      assertThat(p.getAllProperties(), not(hasItem(p1)));
    }

    @Test
    public void testSaveProperty() {
        
      p.saveProperty(p3);
      assertThat(p.getAllProperties(), hasSize(3));
      assertThat(p.getAllProperties(), hasItem(p1));
      assertThat(p.getAllProperties(), hasItem(p2));
      assertThat(p.getAllProperties(), hasItem(p3));
    }

    @Test
    public void testAddToWishList() {
    }
    
}
