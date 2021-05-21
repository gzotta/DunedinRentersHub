/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import static com.typesafe.config.ConfigFactory.parseString;
import dao.PropertyJdbcDAO;
import domain.Booking;
import domain.Property;
import domain.Renter;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author zotta
 */
public class PropertyModule extends Jooby {

    public PropertyModule(PropertyJdbcDAO propertyDao) {

        //Filter properties by room (GET).
        get("/api/properties/:bedrooms", (req) -> {
            String bedrooms = req.param("bedrooms").value();
            return propertyDao.filterByBedroom(Integer.parseInt(bedrooms));
        });

        
        
        //Get number of bedrooms
        get("/api/bedrooms/", () -> {
            return propertyDao.getBedrooms();
        });
        
        
         //Get filter by bedrooms
        get("/api/bedrooms/:bedroom", (req) -> {
            String bedroom = req.param("bedroom").value();
            return propertyDao.filterByBedroom((Integer.valueOf(bedroom)));
            
        });
        
        
        
        

        //GET all properties.
        get("/api/properties", () -> propertyDao.getAllProperties());

        //DELETE property.
        delete("/api/properties/:id", (req, rsp) -> {
            String id = req.param("id").value();
            Property property = propertyDao.getPropertyById(Integer.parseInt(id));
            propertyDao.removeProperty(property);
            rsp.status(Status.NO_CONTENT);
        });

        //Save (POST) property.
        post("/api/properties", (req, rsp) -> {
            Property property = req.body().to(Property.class);
            propertyDao.saveProperty(property);
            rsp.status(Status.CREATED);
        });

        //Add (POST) property to wishlist.
//        post("/api/wishlist", (req, rsp) -> {
//            Property property = req.body().to(Property.class);
//            Renter renter = req.body().to(Renter.class);
//            propertyDao.addToWishList(renter, property);
//            rsp.status(Status.CREATED);
//        });

    }

}
