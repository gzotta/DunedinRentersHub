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
    private String userName;
    private Date dateOfBirth;
    private String renterPhone;
    private String renterEmail;
    private String references;
    private ArrayList<Wishlist> wishList;

    public Renter() {
    }

    //doesn't coontain wishlist as there wouldnt be a wishlist when renter is initially created
    public Renter(Integer renterId, String renterPassword, String userName, Date dateOfBirth, String renterPhone, String renterEmail, String references) {
        this.renterId = renterId;
        this.renterPassword = renterPassword;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.renterPhone = renterPhone;
        this.renterEmail = renterEmail;
        this.references = references;
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

    public ArrayList<Wishlist> getWishList() {
        return wishList;
    }

    //don't think this is needed here as it will be done via the dao
//    public void addToWishList(Wishlist w) {
//        wishList.add(w);
//    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.renterId);
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
        final Renter other = (Renter) obj;
        if (!Objects.equals(this.renterId, other.renterId)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
