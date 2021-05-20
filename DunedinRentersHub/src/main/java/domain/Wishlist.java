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

    Renter renter;
    Property property;

    public Wishlist() {
    }

    public Wishlist(Renter renter, Property property) {
        this.renter = renter;
        this.property = property;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

}
