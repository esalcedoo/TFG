/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author elena
 */
public class URI_Access {
    
    public void store_URI(String name, String uri){
        Properties urls = new Properties();
        OutputStream output = null;
        try {
            File file = new File("URL.properties");
            if (!file.exists()){
                file.createNewFile();
            }
            
            output = new FileOutputStream(file, false);

            // set the URL value
            urls.setProperty(name,uri);

            // save properties to project root folder
            urls.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                        output.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }
    }

    public String get_URI(String name){
        Properties urls = new Properties();
	InputStream input = null;
        String uri = null;
	try {
            input = new FileInputStream("URL.properties");
            // load a properties file
            urls.load(input);

            // get the property value and print it out
            uri= urls.getProperty(name);
 
	} catch (IOException ex) {
            ex.printStackTrace(System.out);
	} finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
	}
        return uri;
    }
}
