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

    public Renter(String username, String email, String phone) {
        this.userName = username;
        this.renterEmail = email;
        this.renterPhone = phone;
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
