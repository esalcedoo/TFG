/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntProperty;

/**
 *
 * @author elena
 */
public class PassengerInfoEquipment extends StopPlaceEquipment{

    private OntClass passengerInfoEquipment;
    private OntProperty passengerInfoFacilityType;
    private OntProperty attribute1;
    
    /**
     * Accessibility Info Enumeration
     */
    public enum acc_info{
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
        store_URI("PIE", get_URI("NS") + "/PassengerInfoEquipment");
        passengerInfoEquipment = ontologia.createClass(get_URI("PIE"));
        passengerInfoEquipment.addSuperClass(stopPlaceEquipment);       
    }
    
    private void add_property_passengerInfoFacilityType(acc_info ai){
        store_URI("PIE_AI", get_URI("NS") + "/PassengerInfoEquipment");
        passengerInfoFacilityType = ontologia.createOntProperty(get_URI("PIE_AI"));
        passengerInfoEquipment.addProperty(passengerInfoFacilityType, ai.toString());       
    }

    private void add_property_attribute1(pt_info_fac pif){
        passengerInfoEquipment.addProperty(attribute1, pif.toString());
    }
    
    // Getters & Setters
    public OntClass getPassengerInfoEquipment() {
        return passengerInfoEquipment;
    }

    public void setPassengerInfoEquipment(OntClass passengerInfoEquipment) {
        this.passengerInfoEquipment = passengerInfoEquipment;
    }

    public OntProperty getPassengerInfoFacilityType() {
        return passengerInfoFacilityType;
    }

    public void setPassengerInfoFacilityType(OntProperty passengerInfoFacilityType) {
        this.passengerInfoFacilityType = passengerInfoFacilityType;
    }

    public OntProperty getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(OntProperty attribute1) {
        this.attribute1 = attribute1;
    }    
}
