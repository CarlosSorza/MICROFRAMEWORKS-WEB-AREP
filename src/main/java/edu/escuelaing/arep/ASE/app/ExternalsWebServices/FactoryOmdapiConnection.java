package edu.escuelaing.arep.ASE.app.ExternalsWebServices;

import edu.escuelaing.arep.ASE.app.ExternalsWebServices.impl.omdbapiConnection;


/**
    * class that return a instance of omdapiConnection
*/
public class FactoryOmdapiConnection implements FactoryExternalsService {

    /**
    * method that connect with a omdapi
    * @param URL : url of api
    * @param apikey : key that connect with the api
    */
    @Override
    public ExternalServices connection(String url, String apikey) {
      
        return new omdbapiConnection(url, apikey);
    }
    
}
