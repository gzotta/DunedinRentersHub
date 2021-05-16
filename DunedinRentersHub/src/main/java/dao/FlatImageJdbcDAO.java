/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.FlatImage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    String sql = "select * from FlatImage";
  
    try (
    Connection dbCon = DbConnection.getConnection(databaseURI);
    PreparedStatement stmt = dbCon.prepareStatement(sql);) {
       
        //You can store the image data assuming image ID is generated in DB
        FlatImage fi = new FlatImage();
        stmt.setString(1, fi.getDescription());
        stmt.setBytes(2, fi.getData());
        stmt.setString(3, fi.getMediaType());
        
        stmt.executeUpdate();
        
        ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //retrive data 
                Integer imageId = rs.getInt("IMAGE_ID");
                String description = rs.getString("DESCRIPTION");
                byte[] data = rs.getBytes("IMAGE");
                String mediaType = rs.getString("MEDIA_TYPE");
              
                return new FlatImage(imageId, description, data, mediaType);

            } else {

                return null;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }    
      
  
  }







}

}
