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
public class Services {
    
    private Integer serviceId;
    private String serviceType;
    private String servicePassword;
    private String username;
    private String servicePhone;
    private String serviceEmail;

    public Services() {
    }

    public Services(Integer serviceId, String serviceType, String servicePassword, String username, String servicePhone, String serviceEmail) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.servicePassword = servicePassword;
        this.username = username;
        this.servicePhone = servicePhone;
        this.serviceEmail = serviceEmail;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServicePassword() {
        return servicePassword;
    }

    public void setServicePassword(String servicePassword) {
        this.servicePassword = servicePassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public String getServiceEmail() {
        return serviceEmail;
    }

    public void setServiceEmail(String serviceEmail) {
        this.serviceEmail = serviceEmail;
    }
  
    
    
   
}
