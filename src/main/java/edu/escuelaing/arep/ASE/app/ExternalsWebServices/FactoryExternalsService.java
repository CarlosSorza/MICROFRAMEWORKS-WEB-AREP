package edu.escuelaing.arep.ASE.app.ExternalsWebServices;


/**
    * interface that define connection with externals services
*/
public interface FactoryExternalsService {

    /**
    * method that connect with a api
    * @param URL : url of api
    * @param apikey : key that connect with the api
    */
    ExternalServices connection(String url, String apikey);


    
}
