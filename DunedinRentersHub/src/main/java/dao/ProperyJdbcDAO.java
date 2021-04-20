/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author maxer
 */
public class ProperyJdbcDAO {
    
    private String databaseURI = DbConnection.getDefaultConnectionUri();
    
    //default construcot

    public ProperyJdbcDAO() {
    }
    
    //constructor that intialises the URI
    public ProperyJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }
    
}
