/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;

import com.hp.hpl.jena.ontology.OntClass;

/**
 *
 * @author elena
 */
public class StopPlaceEquipment extends Ontology{

    OntClass stopPlaceEquipment;
    public StopPlaceEquipment() {
        store_URI("NS","http://www.vortic3.com/IFOPT/StopPlaceEquipment");
        // Create Ontology Class
        System.out.println("crea url NS");
        stopPlaceEquipment = ontologia.createClass(get_URI("NS"));
    }
    @Override
    public String toString(){
        return get_URI("NS");
    }
    
}
