/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.vocabulary.RDFS;
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
            OntProperty attribute1 = ontologia.createOntProperty(NS+"PTInfoFacility");
        passengerInfoEquipment.addProperty(passengerInfoFacilityType, acc_info);
        //Hola esto es una prueba de commit
    
        ontologia.write(System.out);
        
        BLA  BLA BLA BLA BLA BLA
    }
    
}
