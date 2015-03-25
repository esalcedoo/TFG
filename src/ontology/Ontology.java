/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.RDFS;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
/**
 *
 * @author elena
 */
public class Ontology {
//        final static String AE = NS + "/AccessEquipment";
//        final static String S = NS + "/Sign";
    
    protected final static OntModel ontologia = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
    
    protected final void store_URI(String name, String uri){
        Properties urls = new Properties();
        OutputStream output = null;
        try {
            File file = new File("URL.properties");
            if (!file.exists()){
                file.createNewFile();
            }
            
            output = new FileOutputStream(file, false);

            // set the URL value
            urls.setProperty(name,uri);

            // save properties to project root folder
            urls.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                        output.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }
    }
    
    protected final String get_URI(String name){
        Properties urls = new Properties();
	InputStream input = null;
        String uri = null;
	try {
            input = new FileInputStream("URL.properties");
            // load a properties file
            urls.load(input);

            // get the property value and print it out
            uri= urls.getProperty(name);
 
	} catch (IOException ex) {
            ex.printStackTrace(System.out);
	} finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
	}
        return uri;
    }
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        // Create stopPlace individuals
        Individual vodafoneSol;
                
        vodafoneSol = ontologia.createIndividual(new StopPlaceEquipment().toString()+"/VodafoneSol", RDFS.Resource);
        
        //Create passengerInfoEquipment Individual;
        Individual passengerInfoEquipment;
        
        
        ontologia.write(System.out);
        
        
        
    }
           


}
