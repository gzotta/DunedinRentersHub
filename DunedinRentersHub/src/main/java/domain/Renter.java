/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.google.j2objc.annotations.Property;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author zotta
 */
public class Renter {
    
    private Integer renterId;
    private String renterPassword;
    private String userName;
    private Date dateOfBirth;
    private String renterPhone;
    private String renterEmail;
    private String references;
    private ArrayList<Property> wishList;

    public Renter() {
    }


    public Renter(Integer renterId, String renterPassword, String userName, Date dateOfBirth, String renterPhone, String renterEmail, String references, ArrayList<Property> wishList) {
        this.renterId = renterId;
        this.renterPassword = renterPassword;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.renterPhone = renterPhone;
        this.renterEmail = renterEmail;
        this.references = references;
        this.wishList = wishList;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return renterEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public ArrayList<Property> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Property> wishList) {
        this.wishList = wishList;
    }

    public void setEmail(String email) {
        this.renterEmail = email;
    }

    public String getPhone() {
        return renterPhone;
    }

    public void setPhone(String phone) {
        this.renterPhone = phone;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }    
}
