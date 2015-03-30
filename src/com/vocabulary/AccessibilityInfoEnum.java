/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vocabulary;

/**
 *
 * @author elena
 */
import com.hp.hpl.jena.datatypes.BaseDatatype;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.uris.URI_Access;

/**
 * Defines Jena resources corresponding to the URIs for 
 * the XSD primitive datatypes which are known to Jena. 
 */
public class AccessibilityInfoEnum extends BaseDatatype{    
    /**
     * The RDF-friendly version of the AccessibilityInfoEnum namespace
 with trailing # character.
     */
    
    
    private static final String AIE="/AccesibilityInfoEnum";
    
    /** Resource URI for AccessibilityInfoEnum:audioInformation */
    public static Resource audioInformation;
    
    /** Resource URI for AccessibilityInfoEnum:audioForHearingImpaired */
    public static Resource audioForHearingImpaired;
    
    /** Resource URI for AccessibilityInfoEnum:visualDisplays */
    public static Resource visualDisplays;
    
    /** Resource URI for AccessibilityInfoEnum:displaysForVisuallyImpaired */
    public static Resource displaysForVisuallyImpaired;
       
    /** Resource URI for AccessibilityInfoEnum:tactilePlatformEdges */
    public static Resource tactilePlatformEdges;
       
    /** Resource URI for AccessibilityInfoEnum:tactileGuidingStrips */
    public static Resource tactileGuidingStrips;
       
    /** Resource URI for AccessibilityInfoEnum:largePrintTimetables */
    public static Resource largePrintTimetables;
    
    public static String uri(){
        URI_Access uriAccess=new URI_Access();
        return uriAccess.get_URI("EDT") + AIE;
    }
   
    // Initializer
    static {
        audioInformation = ResourceFactory.createResource(AIE + "#audioInformation");
        audioForHearingImpaired = ResourceFactory.createResource(AIE + "#audioForHearingImpaired");
        visualDisplays = ResourceFactory.createResource(AIE + "#visualDisplays");
        displaysForVisuallyImpaired = ResourceFactory.createResource(AIE + "#displaysForVisuallyImpaired");
        tactilePlatformEdges = ResourceFactory.createResource(AIE + "#tactilePlatformEdges");
        tactileGuidingStrips = ResourceFactory.createResource(AIE + "#tactileGuidingStrips");
        largePrintTimetables = ResourceFactory.createResource(AIE + "#largePrintTimetables");
    }

        // Initializer
//    static { URI ENTERA
//        URI_Access uriAccess=new URI_Access();
//        audioInformation = ResourceFactory.createResource(uriAccess.get_URI("EDT") + AIE + "#audioInformation");
//        audioForHearingImpaired = ResourceFactory.createResource(uriAccess.get_URI("EDT") + AIE + "#audioForHearingImpaired");
//        visualDisplays = ResourceFactory.createResource(uriAccess.get_URI("EDT") + AIE + "#visualDisplays");
//        displaysForVisuallyImpaired = ResourceFactory.createResource(uriAccess.get_URI("EDT") + AIE + "#displaysForVisuallyImpaired");
//        tactilePlatformEdges = ResourceFactory.createResource(uriAccess.get_URI("EDT") + AIE + "#tactilePlatformEdges");
//        tactileGuidingStrips = ResourceFactory.createResource(uriAccess.get_URI("EDT") + AIE + "#tactileGuidingStrips");
//        largePrintTimetables = ResourceFactory.createResource(uriAccess.get_URI("EDT") + AIE + "#largePrintTimetables");
//    }
    
    public AccessibilityInfoEnum() {
        super(AIE);
    }
}

