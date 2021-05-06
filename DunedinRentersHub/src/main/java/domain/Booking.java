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
    private String landlordId;
    private String propertyId;
    private String renterId;

    public Booking() {
    }

    public Booking(Integer bookingId, LocalDateTime date, String landlordId, String propertyId, String renterId) {
        this.bookingId = bookingId;
        this.date = date;
        this.landlordId = landlordId;
        this.propertyId = propertyId;
        this.renterId = renterId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Booking other = (Booking) obj;
        if (!Objects.equals(this.landlordId, other.landlordId)) {
            return false;
        }
        if (!Objects.equals(this.propertyId, other.propertyId)) {
            return false;
        }
        if (!Objects.equals(this.renterId, other.renterId)) {
            return false;
        }
        if (!Objects.equals(this.bookingId, other.bookingId)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }


    


 
}
