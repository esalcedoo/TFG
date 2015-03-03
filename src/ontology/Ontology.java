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
import com.hp.hpl.jena.vocabulary.OWL;
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
            final String PIE = NS + "#PassengerInfoEquipment";
                final String PIE_AI = PIE + "#AccessibilityInfoEnum";
            final String AE = NS + "#AccessEquipment";
            final String S = NS + "#Sign";
        
        
        // Create Ontology
        final OntModel ontologia = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
        
        // Specify Access Metro prefix 
        ontologia.setNsPrefix("AccM", NS);
        
        // Create Ontology Classes
        final OntClass stopPlaceEquipment = ontologia.createClass(NS);
        final OntClass passengerInfoEquipment = ontologia.createClass(PIE);
        final OntClass accessEquipment = ontologia.createClass(AE);
        final OntClass sign = ontologia.createClass(S);
        
        // Add hierarchy Properties (creo que esto es repetir las cosas pero ahí lo dejo hasta que esté segura)
        
        stopPlaceEquipment.addSubClass(passengerInfoEquipment);
        stopPlaceEquipment.addSubClass(accessEquipment);
        stopPlaceEquipment.addSubClass(sign);
        
        stopPlaceEquipment.addRDFType(passengerInfoEquipment);
        stopPlaceEquipment.addRDFType(accessEquipment);
        stopPlaceEquipment.addRDFType(sign);
        
        ontologia.write(System.out);
        
        // Add attributes Properties
        
        //PassengerInfoEquipment
        OntProperty passengerInfoFacilityType = ontologia.createOntProperty(PIE);
            passengerInfoFacilityType.addProperty(RDFS.domain, passengerInfoEquipment);
            //passengerInfoFacilityType.addRange(XSD.xenum);
                //AccessibilityInfoEnum
                RDFList acc_info = ontologia.createList();
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#audioInformation", OWL.Thing));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#audioForHearingImpaired", OWL.Thing));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#visualDisplays", OWL.Thing));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#displaysForVisuallyImpaired", OWL.Thing));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#tactilePlatformEdges", OWL.Thing));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#tactileGuidingStrips", OWL.Thing));
                acc_info.cons(ontologia.createIndividual(PIE_AI+ "#largePrintTimetables", OWL.Thing));
            
            OntClass accesibility_info = ontologia.createEnumeratedClass(PIE_AI, acc_info);
            passengerInfoFacilityType.addRange(accesibility_info);
            OntProperty attribute1 = ontologia.createOntProperty(NS+"PTInfoFacility");
        
    }
    
}
