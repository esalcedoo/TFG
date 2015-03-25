/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;

import com.URI_Access;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.XSD;
import com.vocabulary.EnumDataType;

/**
 *
 * @author elena
 */
public class PassengerInfoEquipment extends StopPlaceEquipment{
    
    private OntClass passengerInfoEquipment_class;
    private OntProperty passengerInfoFacilityType;
    private OntProperty attribute1;
    
    /**
     * Accessibility Info Enumeration
     */
    public static enum acc_info{
        audioInformation,audioForHearingImpaired,visualDisplays,
        displaysForVisuallyImpaired,tactilePlatformEdges,
        tactileGuidingStrips,largePrintTimetables;
    }  
    /**
     * PT Facility Info Enumeration
     */
    public enum pt_info_fac{
        timetablePoster, fareInformation, lineNetworkPlan,
        lineTimetable, stopTimetable;
    }
    
    public PassengerInfoEquipment() {
        URI_Access uriAccess=new URI_Access();
        uriAccess.store_URI("PIE", uriAccess.get_URI("NS") + "/PassengerInfoEquipment");
        passengerInfoEquipment_class = ontologia.createClass(uriAccess.get_URI("PIE"));
        passengerInfoEquipment_class.addSuperClass(getStopPlaceEquipment());       
    //}
    
    //private void add_property_passengerInfoFacilityType(acc_info ai){
    //    URI_Access uriAccess=new URI_Access();
        uriAccess.store_URI("PIE_PIFT", uriAccess.get_URI("PIE") + "/PassengerInfoFacilityType");
        passengerInfoFacilityType = ontologia.createOntProperty(uriAccess.get_URI("PIE_PIFT"));
        //passengerInfoFacilityType.addRange((Resource) EnumDataType.acc_info);
        passengerInfoFacilityType.addRange(EnumDataType.acc_info);
        passengerInfoFacilityType.addDomain(passengerInfoEquipment_class);
        
    //    passengerInfoEquipment_class.addProperty(passengerInfoFacilityType, :::::);       
    //}

    //private void add_property_attribute1(pt_info_fac pif){
        //uriAccess.store_URI("PIE_A1", uriAccess.get_URI("PIE") + "/Attribute1");
        //attribute1 = ontologia.createOntProperty(uriAccess.get_URI("PIE_A1"));
        
    //    passengerInfoEquipment_class.addProperty(attribute1, :::::);
    }
    
    // Getters & Setters
    public OntClass getPassengerInfoEquipment_class() {
        return passengerInfoEquipment_class;
    }

    public OntProperty getPassengerInfoFacilityType() {
        return passengerInfoFacilityType;
    }

    public OntProperty getAttribute1() {
        return attribute1;
    }
    
    public String toString(){
        URI_Access uriAccess=new URI_Access();
        return uriAccess.get_URI("PIE");
    }
}
