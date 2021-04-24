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
    Landlord landlord;

    public Wishlist() {
    }

    public Wishlist(Renter renter, Landlord landlord) {
        this.renter = renter;
        this.landlord = landlord;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }
    
    
}
