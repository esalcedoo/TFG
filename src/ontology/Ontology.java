/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;
import com.hp.hpl.jena.ontology.HasValueRestriction;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.hp.hpl.jena.vocabulary.XSD;
/**
 *
 * @author elena
 */
public class Ontology {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String NS = "http://www.vortic3.com/IFOPT/StopPlaceEquipment";
            final String PIE = NS + "/PassengerInfoEquipment";
                final String PIE_AI = PIE + "/AccessibilityInfoEnum";
                final String PIE_IF = PIE + "PTInfoFacilityEnum";
            final String AE = NS + "/AccessEquipment";
            final String S = NS + "/Sign";
        
        
        // Create Ontology
        final OntModel ontologia = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        
        // Specify Access Metro prefix 
        ontologia.setNsPrefix("AccM", NS);
        
        // Create Ontology Classes
        final OntClass stopPlaceEquipment = ontologia.createClass(NS);
        final OntClass passengerInfoEquipment = ontologia.createClass(PIE);
        final OntClass accessEquipment = ontologia.createClass(AE);
        final OntClass sign = ontologia.createClass(S);
        
        // Add hierarchy Properties
        
        stopPlaceEquipment.addSubClass(passengerInfoEquipment);
        stopPlaceEquipment.addSubClass(accessEquipment);
        stopPlaceEquipment.addSubClass(sign);        
        
        
        // Add attributes Properties
        
        //PassengerInfoEquipment
         //PassengerInfoFacilityType
        OntProperty passengerInfoFacilityType = ontologia.createOntProperty(PIE);
            passengerInfoFacilityType.addProperty(RDFS.domain, passengerInfoEquipment);
                //AccessibilityInfoEnum
                RDFList acc_info = ontologia.createList();
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#audioInformation", RDFS.label));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#audioForHearingImpaired", RDFS.label));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#visualDisplays", RDFS.label));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#displaysForVisuallyImpaired", RDFS.label));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#tactilePlatformEdges", RDFS.label));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#tactileGuidingStrips", RDFS.label));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#largePrintTimetables", RDFS.label));
            
            OntClass accesibility_info = ontologia.createEnumeratedClass(PIE_AI, acc_info);
            passengerInfoFacilityType.addRange(accesibility_info);
        passengerInfoEquipment.addProperty(passengerInfoFacilityType, acc_info);
       
         //Atribute1
        OntProperty attribute1 = ontologia.createOntProperty(AE);  
            attribute1.addProperty(RDFS.domain, passengerInfoEquipment);
                //PTInfoFacilityEnum
                RDFList info_fac = ontologia.createList();
                info_fac.cons(ontologia.createIndividual(PIE_IF+ "#timetablePoster", RDFS.label));
                info_fac.cons(ontologia.createIndividual(PIE_IF+ "#fareInformation", RDFS.label));
                info_fac.cons(ontologia.createIndividual(PIE_IF+ "#lineNetworkPlan", RDFS.label));
                info_fac.cons(ontologia.createIndividual(PIE_IF+ "#lineTimetable", RDFS.label));
                info_fac.cons(ontologia.createIndividual(PIE_IF+ "#stopTimetable", RDFS.label));
            OntClass ptInfoFacility = ontologia.createEnumeratedClass(PIE_IF, info_fac);
            attribute1.addRange(ptInfoFacility);
        passengerInfoEquipment.addProperty(attribute1, info_fac);
        
        
        
        //AbstractAccessEquipment
         //Width
        OntProperty width = ontologia.createOntProperty(AE);
            width.addProperty(RDFS.domain, accessEquipment);
            width.addRange(XSD.xfloat); //metres
        accessEquipment.addProperty(width, info_fac);
        
                    
        Individual VodafoneSol = ontologia.createIndividual(stopPlaceEquipment.toString()+"VodafoneSol", OWL.Thing);
        
        VodafoneSol.addProperty(passengerInfoFacilityType, acc_info.get(0));
        
        VodafoneSol.addRDFType(stopPlaceEquipment);

        ontologia.write(System.out);
    }
    

}
