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
    private Integer landlordId;
    private Integer propertyId;
    private Integer renterId;

    public Booking() {
    }

    public Booking(Integer bookingId, LocalDateTime date, Integer landlordId, Integer propertyId, Integer renterId) {
        this.bookingId = bookingId;
        this.date = date;
        this.landlordId = landlordId;
        this.propertyId = propertyId;
        this.renterId = renterId;
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

    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }




    


 
}
