/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Landlord;
import domain.Property;
import domain.Renter;
import java.util.Date;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sarahaverill
 */
public class PropertyJdbcDAOTest {

    PropertyJdbcDAO p = new PropertyJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    LandlordJdbcDAO l = new LandlordJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    RenterJdbcDAO r = new RenterJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");

    private Property p1;
    private Property p2;
    private Property p3;

    private Landlord l1;
    private Landlord l2;
    private Landlord l3;

    private Renter r1;

    public PropertyJdbcDAOTest() {
    }

    @BeforeEach
    public void setUp() {

        l1 = new Landlord();
        //l1.setLandlordId(12345);
        l1.setLandlordEmail("email1@email.com");
        l1.setLandlordPassword("password1");
        l1.setLandlordPhone("phone1");
        l1.setUserName("username1");

        l2 = new Landlord();
        l2.setLandlordEmail("email2@email.com");
        l2.setLandlordPassword("password2");
        l2.setLandlordPhone("phone2");
        l2.setUserName("username2");

        l3 = new Landlord();
        l3.setLandlordEmail("email3@email.com");
        l3.setLandlordPassword("password3");
        l3.setLandlordPhone("phone3");
        l3.setUserName("username3");

        l.saveLandlord(l1);
        l.saveLandlord(l2);
        l.saveLandlord(l3);

        p1 = new Property();
        p2 = new Property();
        p3 = new Property();

        p1.setBedrooms(1);
        p1.setLandlordId(l1.getLandlordId());
        p1.setAddress("A1");
        p1.setStatus("D1");
        //p1.setPropertyId(12345);

        p2.setBedrooms(2);
        p2.setLandlordId(l2.getLandlordId());
        p2.setAddress("A2");
        p2.setStatus("D2");
        //p2.setPropertyId(4567);

        p3.setBedrooms(3);
        p3.setLandlordId(l3.getLandlordId());
        p3.setAddress("A3");
        p3.setStatus("D3");
        //p3.setPropertyId(7895);

        p.saveProperty(p1);
        p.saveProperty(p2);
        //p.saveProperty(p3);

        r1 = new Renter();
        r1.setDateOfBirth(new java.sql.Date(1996 - 06 - 06));
        r1.setRenterEmail("email1");
        r1.setRenterPhone("666666");
        r1.setReferences("references1");
        r1.setRenterPassword("thepassword");
        r1.setUserName("renterUsernam1");

        r.saveRenter(r1);

    }

    @AfterEach
    public void tearDown() {
        r.removeWishList(r1);
        p.removeProperty(p1);
        p.removeProperty(p2);
        p.removeProperty(p3);
        l.removeLandlord(l1);
        l.removeLandlord(l2);
        l.removeLandlord(l3);
        r.removeRenter(r1);

    }

    @Test
    public void testFilterByBedroom() {
        assertThat(p.filterByBedroom(p1.getBedrooms()), hasSize(1));
        assertThat(p.filterByBedroom(p1.getBedrooms()), not(hasItem(p2)));
    }

    @Test
    public void testGetAllProperties() {
        assertThat(p.getAllProperties(), hasSize(2));

    }

    @Test
    public void testGetBedrooms() {
        assertThat(p.getBedrooms(), hasSize(2));

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
        assertThat(p.getPropertyById(p1.getPropertyId()), samePropertyValuesAs(p1));
        assertThat(p.getPropertyById(p2.getPropertyId()), samePropertyValuesAs(p2));
        assertThat(p.getPropertyById(p3.getPropertyId()), samePropertyValuesAs(p3));
    }

    @Test
    public void testAddToWishList() {
        p.addToWishList(r1, p1);
        assertThat(r.getRenterWishlist(r1), hasSize(1));

    }

}
