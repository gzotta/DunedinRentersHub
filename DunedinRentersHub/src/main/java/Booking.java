
import java.util.ArrayList;
import java.util.Date;

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

    private Integer propertyId;
    private Integer landlordId;
    private Integer renterId;
    private String address; 
    private Date bookinDate;

    public Booking() {
    }
 
 
    public Booking(Integer propertyId, Integer landlordId, Integer renterId, String address, Date bookinDate) {
        this.propertyId = propertyId;
        this.landlordId = landlordId;
        this.renterId = renterId;
        this.address = address;
        this.bookinDate = bookinDate;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBookinDate() {
        return bookinDate;
    }

    public void setBookinDate(Date bookinDate) {
        this.bookinDate = bookinDate;
    }
    
 


}
