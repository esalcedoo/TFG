/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;
import com.URI_Access;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.vocabulary.AccessibilityInfoEnum;
import com.vocabulary.EnumDataType;
import java.util.logging.Level;
import java.util.logging.Logger;
import ontology.PassengerInfoEquipment;
import static ontology.PassengerInfoEquipment.acc_info.audioInformation;
/**
 *
 * @author elena
 */
public class Ontology {
//        final static String AE = NS + "/AccessEquipment";
//        final static String S = NS + "/Sign";           
    /**
     * @param args the command line arguments
     * 
     */
    
    protected static OntModel ontologia = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
    private static long millis = 30000;
    
    public static void main(String[] args) {
        // Create OntClases
        URI_Access uriAccess=new URI_Access();
        uriAccess.store_URI("IFOPT","http://www.vortic3.com/IFOPT");
        System.out.println("Hola esta es la uri del ifopt ONTOLOGY" + uriAccess.get_URI("IFOPT"));
        //try {
        //    Thread.sleep(millis);
        //} catch (InterruptedException ex) {
        //    Logger.getLogger(Ontology.class.getName()).log(Level.SEVERE, null, ex);
        //}
        PassengerInfoEquipment passengerInfoEquipment=new PassengerInfoEquipment();
        // Create Individuals
        Individual instance_passengerInfoEquipment = ontologia.createIndividual(passengerInfoEquipment.toString(),passengerInfoEquipment.getPassengerInfoEquipment_class());

        instance_passengerInfoEquipment.addLiteral(passengerInfoEquipment.getPassengerInfoFacilityType(),audioInformation);
        
        ontologia.write(System.out);        
        
    }
           


}
