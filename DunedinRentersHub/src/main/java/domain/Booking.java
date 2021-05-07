package domain;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarahaverill
 */
public class Booking {

    private Integer bookingId;
    private LocalDateTime date;
    private Landlord landlord;
    private Property property;
    private Renter renter;

    public Booking() {
    }

    public Booking(Integer bookingId, LocalDateTime date, Landlord landlord, Property property, Renter renter) {
        this.bookingId = bookingId;
        this.date = date;
        this.landlord = landlord;
        this.property = property;
        this.renter = renter;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

   



  
 
}
