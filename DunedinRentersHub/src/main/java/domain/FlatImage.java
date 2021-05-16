/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author sarahaverill
 */

public class FlatImage {

    private Integer imageId;
    private String description;
    private byte[] data;
    private String mediaType;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

        // load the image data from a file path
    public void loadImage(String path) {
       try {
          File file = new File(path);
          Long fileLength = file.length();
          ByteBuffer buff = ByteBuffer.allocate(fileLength.intValue());
          try (
             RandomAccessFile raf = new RandomAccessFile(file, "r");
             FileChannel channel = raf.getChannel();
          ) {
             channel.read(buff);
             buff.flip();
             this.mediaType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(buff.array()));
             this.data = buff.array();
          }

       } catch (IOException ex) {
          ex.printStackTrace();
       }
    }
}
