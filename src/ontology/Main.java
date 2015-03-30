/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.uris.URI_Access;
import static com.vocabulary.AccessibilityInfoEnum.*;
import static com.vocabulary.PTInfoFacilityEnum.*;

/**
 *
 * @author elena
 */
public class Main {
    // Language
    static String lang = "en";
    
    public static void main(String[] args) {
        //Main options = new Main();
        OntModel ontologia = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        // Create OntClases
        
        //Individual instance_stopPlace = options.individual_stopPlace(ontologia,"Vodafone_Sol");
        //Individual instance_passengerInfoEquipment = options.individual_passengerInfoEquipment(ontologia, audioInformation, timetablePoster);
        
        // Ont Property
        //OntProperty property_hasEquipment = options.property_hasEquipment(ontologia, instance_stopPlace, instance_passengerInfoEquipment);
        
        //instance_stopPlace.addProperty(null, null);
        //ontologia.write(System.out);           
    //}
    
    /**
    * @param stopPlace String refers the name of the Stop Place we want to represent in the model
    * @return An Individual resource.
    */
    //private Individual individual_stopPlace(OntModel ontologia, String stopPlace){
        // Create OntClases
        StopPlaceEquipment stopPlaceEquipment = new StopPlaceEquipment(ontologia);
        Individual instance_stopPlace = ontologia.createIndividual(stopPlaceEquipment.toString() + "_Sol",stopPlaceEquipment.getStopPlaceEquipment_class());
       
        instance_stopPlace.addLabel("Vodafone_Sol",lang);
        //return instance_stopPlace;
    //}
    
    /**
    * @param args Resource[] contains enum vocabulary resources to complete the attributes of the passengerInfoEquipment class
    * @return An Individual resource.
    */
    //private Individual individual_passengerInfoEquipment(OntModel ontologia, Resource r1, Resource r2){
        
        
        PassengerInfoEquipment passengerInfoEquipment=new PassengerInfoEquipment(ontologia);
        Individual instance_passengerInfoEquipment = ontologia.createIndividual(passengerInfoEquipment.toString(),passengerInfoEquipment.getPassengerInfoEquipment_class());
        //add
        instance_passengerInfoEquipment.addLiteral(passengerInfoEquipment.getPassengerInfoFacilityType(),audioInformation);
        instance_passengerInfoEquipment.addLiteral(passengerInfoEquipment.getAttribute1(), timetablePoster);
        
        //return instance_passengerInfoEquipment;
    //}
    
    //private OntProperty property_hasEquipment(OntModel ontologia, Resource domain, Resource range){
        URI_Access uriAccess=new URI_Access();
        OntProperty property_hasEquipment = ontologia.createOntProperty(uriAccess.get_URI("NS")+ "/hasEquipment");
        property_hasEquipment.addProperty(RDFS.comment, "Actual equipment of stop place");
        property_hasEquipment.addProperty(RDFS.domain, stopPlaceEquipment.getStopPlaceEquipment_class());
        property_hasEquipment.addProperty(RDFS.range, passengerInfoEquipment.getPassengerInfoEquipment_class());
        
        //return property_hasEquipment;
    
        ontologia.write(System.out); 
    }
    
    
}
