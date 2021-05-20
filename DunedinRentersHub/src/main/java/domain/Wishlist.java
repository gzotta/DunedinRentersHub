/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author maxer
 */
public class Wishlist {

    Integer renterId;
    Integer propertyId;

    public Wishlist() {
    }

    public Wishlist(Integer renterId, Integer propertyId) {
        this.renterId = renterId;
        this.propertyId = propertyId;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    

}
