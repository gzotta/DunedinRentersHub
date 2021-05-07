/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Landlord;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sarahaverill
 */
public class LandlordJdbcDAOTest {

    LandlordJdbcDAO landlordDao = new LandlordJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");

    private Landlord landlord1;
    private Landlord landlord2;

    @BeforeEach
    public void setUp() {
        landlord1 = new Landlord();
        landlord1.setLandlordEmail("landordemail1");
        landlord1.setLandlordPassword("landlordpassword1");
        landlord1.setLandlordPhone("0285585589");
        landlord1.setUserName("landlorusername1");

        landlord2 = new Landlord();
        landlord2.setLandlordEmail("landordemail2");
        landlord2.setLandlordPassword("landlordpassword2");
        landlord2.setLandlordPhone("0284685589");
        landlord2.setUserName("landlorusername2");

        landlordDao.saveLandlord(landlord1);
        //landlordDao.saveLandlord(landlord2);

    }

    @AfterEach
    public void tearDown() {
        landlordDao.removeLandlord(landlord1);
        landlordDao.removeLandlord(landlord2);

    }

    @Test
    public void testSaveLandlord() {
   
        landlordDao.saveLandlord(landlord2);
        assertThat(landlordDao.getLandlord(landlord2.getUserName()), samePropertyValuesAs(landlord2));
        

    }

    @Test
    public void testGetLandlord() {
        Landlord testGetLandlord = landlordDao.getLandlord(landlord1.getUserName());
        assertThat(testGetLandlord, samePropertyValuesAs(landlord1));

    }

    @Test
    public void testRemoveLandlord() {
        landlordDao.removeLandlord(landlord1);
        assertThat(landlordDao.getLandlord(landlord1.getUserName()), nullValue());
    }
//
//    @Test
//    public void testValidateCredentials() {
//    }

}
