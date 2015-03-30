/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;

import com.uris.URI_Access;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.vocabulary.EnumDataType;

/**
 *
 * @author elena
 */
public class PassengerInfoEquipment extends StopPlaceEquipment{
    
    private final OntClass passengerInfoEquipment_class;
    private final OntProperty passengerInfoFacilityType;
    private final OntProperty attribute1;
    
    /**
     *
     * @param on
     * @param ontologia
     */
    public PassengerInfoEquipment(OntModel ontologia) {
        super(ontologia);
        URI_Access uriAccess=new URI_Access();
        passengerInfoEquipment_class = ontologia.createClass(uriAccess.get_URI("PIE"));
        passengerInfoEquipment_class.addSuperClass(getStopPlaceEquipment_class());       
    //}
    
    //private void add_property_passengerInfoFacilityType(acc_info ai){
    //    URI_Access uriAccess=new URI_Access();
        passengerInfoFacilityType = ontologia.createOntProperty(uriAccess.get_URI("PIE_PIFT"));
        passengerInfoFacilityType.addRange(EnumDataType.acc_info);
        passengerInfoFacilityType.addDomain(passengerInfoEquipment_class);
        
    //    passengerInfoEquipment_class.addProperty(passengerInfoFacilityType, :::::);       
    //}

    //private void add_property_attribute1(pt_info_fac pif){
        //uriAccess.store_URI("PIE_A1", uriAccess.get_URI("PIE") + "/Attribute1");
        attribute1 = ontologia.createOntProperty(uriAccess.get_URI("PIE_A1"));

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
