/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.URI_Access;

/**
 *
 * @author elena
 */
public class StopPlaceEquipment extends Ontology{
    private OntClass stopPlaceEquipment;
    
    public StopPlaceEquipment() {
        URI_Access uriAccess=new URI_Access();
        uriAccess.store_URI("NS",uriAccess.get_URI("IFOPT") + "/StopPlaceEquipment");
        // Create Ontology Class
        System.out.println("crea url NS");
        stopPlaceEquipment = ontologia.createClass(uriAccess.get_URI("NS"));
    }
    
    @Override
    public String toString(){
        URI_Access uriAccess=new URI_Access();
        return uriAccess.get_URI("NS");
    }

    public OntClass getStopPlaceEquipment() {
        return stopPlaceEquipment;
    }    

    public OntModel getOntologia() {
        return ontologia;
    }
}
