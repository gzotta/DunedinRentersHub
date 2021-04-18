
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarahaverill
 */
public class Landlord {
  
    private Integer landlordId;
    private String landlordPassword;
    private String username;
    private String landlordPhone;
    private String landlordEmail;
    private ArrayList<Property> properties;

    public Landlord(Integer landlordId, String landlordPassword, String username, String landlordPhone, String landlordEmail, ArrayList<Property> properties) {
        this.landlordId = landlordId;
        this.landlordPassword = landlordPassword;
        this.username = username;
        this.landlordPhone = landlordPhone;
        this.landlordEmail = landlordEmail;
        this.properties = properties;
    }
    
    public Landlord (){
        
    }

    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    public String getLandlordPassword() {
        return landlordPassword;
    }

    public void setLandlordPassword(String landlordPassword) {
        this.landlordPassword = landlordPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public void setLandlordPhone(String landlordPhone) {
        this.landlordPhone = landlordPhone;
    }

    public String getLandlordEmail() {
        return landlordEmail;
    }

    public void setLandlordEmail(String landlordEmail) {
        this.landlordEmail = landlordEmail;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }
    
}
