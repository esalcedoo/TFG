/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vocabulary;

import com.URI_Access;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

/**
 *
 * @author elena
 */
public class EnumDataType {
    /** Datatype representing EnumDataType:AccessibilityInfoEnum */
    //public static final AccessibilityInfoEnum acc_info = new AccessibilityInfoEnum();
    
    /** Resource URI for AccessibilityInfoEnum:audioInformation */
    public static Resource acc_info;
    
    static {
        //URI_Access uriAccess=new URI_Access();
        //System.out.println("Hola esta es la uri del ifopt" + uriAccess.get_URI("IFOPT"));
        //uriAccess.store_URI("EDT",uriAccess.get_URI("IFOPT") + "/EnumDataType");
        

        acc_info = ResourceFactory.createResource("http://www.vortic3.com/IFOPT/EnumDataType" + AccessibilityInfoEnum.uri());
    }
}
