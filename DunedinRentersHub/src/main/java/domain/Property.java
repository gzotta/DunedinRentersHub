package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarahaverill
 */
public class Property {
    

    private Integer propertyId;
    private Integer landlordId;
    private Integer renterId;
    private String address;
    private String status;

    public Property() {
    }

    public Property(Integer propertyId, Integer landlordId, Integer renterId, String address, String status) {
        this.propertyId = propertyId;
        this.landlordId = landlordId;
        this.renterId = renterId;
        this.address = address;
        this.status = status;
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
     address = property.getAddress();
    }

  
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
