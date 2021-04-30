/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Property;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author sarahaverill
 */
public class PropertyJdbcDAOTest {
    
    PropertyJdbcDAO property = new PropertyJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
   
   private Property property1;
   private Property property2;
   private Property property3;
    
    public PropertyJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
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
    public void testAddToWishList() {
    }
    
}
