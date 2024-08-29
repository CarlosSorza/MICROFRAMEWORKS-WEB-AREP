package edu.escuelaing.arep.ASE.app.ExternalsWebServices;

import java.io.IOException;


/**
    *interface taht define methos of externals web service
*/
public interface ExternalServices {

    /**
    * method that get a film by title
    * @param query : title of the film
    */
    public String getData(String query) throws IOException;

}