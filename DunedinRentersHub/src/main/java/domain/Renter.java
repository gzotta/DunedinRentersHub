/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author zotta
 */
public class Renter {

    private Integer renterId;
    private String renterPassword;
    private String username;
    private Date dateOfBirth;
    private String renterPhone;
    private String renterEmail;
    private String references;
    private ArrayList<Wishlist> wishList;

    public Renter() {
    }

    //doesn't coontain wishlist as there wouldnt be a wishlist when renter is initially created
    public Renter(Integer renterId, String renterPassword, String username, Date dateOfBirth, String renterPhone, String renterEmail, String references) {
        this.renterId = renterId;
        this.renterPassword = renterPassword;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.renterPhone = renterPhone;
        this.renterEmail = renterEmail;
        this.references = references;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public String getRenterPassword() {
        return renterPassword;
    }

    public void setRenterPassword(String renterPassword) {
        this.renterPassword = renterPassword;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRenterPhone() {
        return renterPhone;
    }

    public void setRenterPhone(String renterPhone) {
        this.renterPhone = renterPhone;
    }

    public String getRenterEmail() {
        return renterEmail;
    }

    public void setRenterEmail(String renterEmail) {
        this.renterEmail = renterEmail;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }







    public ArrayList<Wishlist> getWishList() {
        return wishList;
    }

}
