/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



/**
 *
 * @author sarahaverill
 */
public class FlatImageJdbcDAO {
    
private String databaseURI = DbConnection.getDefaultConnectionUri();

public FlatImageJdbcDAO() {
    }   

  public FlatImageJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

  
  public void loadImage(String path) {
      
  
 
// assuming image ID is generated in DB





}

}
