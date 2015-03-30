/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ontology;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.uris.URI_Access;

/**
 *
 * @author elena
 */
public class StopPlaceEquipment{
    private OntClass stopPlaceEquipment_class;
    
    /**
     *
     * @param ontologia
     */
    public StopPlaceEquipment(OntModel ontologia) {
        URI_Access uriAccess=new URI_Access();
        stopPlaceEquipment_class = ontologia.createClass(uriAccess.get_URI("SPE"));
    }
    
    @Override
    public String toString(){
        URI_Access uriAccess=new URI_Access();
        return uriAccess.get_URI("SPE");
    }

    public OntClass getStopPlaceEquipment_class() {
        return stopPlaceEquipment_class;
    }    
}
