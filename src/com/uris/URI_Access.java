/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uris;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elena
 */
public class URI_Access {
    
    public String get_URI(String name){
        Properties urls = new Properties();
        String uri = null;
        String propFileName = "resources/uri.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/uri.properties");
 
        if (inputStream != null) {
            try {
                urls.load(inputStream);
                uri=  urls.getProperty(name);
        
            } catch (IOException ex) {
                Logger.getLogger(URI_Access.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(URI_Access.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return uri;
    }
}
