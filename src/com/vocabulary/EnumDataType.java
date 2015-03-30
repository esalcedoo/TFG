/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vocabulary;

import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.uris.URI_Access;

/**
 *
 * @author elena
 */
public class EnumDataType {
    
    public static Resource acc_info;
    public static Resource pt_info_fac;
    
    static {        
        acc_info = ResourceFactory.createResource(AccessibilityInfoEnum.uri());
        pt_info_fac =ResourceFactory.createResource(PTInfoFacilityEnum.uri());
    }
}
