package edu.escuelaing.arep.ASE.app.services;

import java.io.IOException;

/**
* Interface that define the methods that offers the backend.
*/

public interface FilmService {

    public  String getFilmByTitle(String query, String URL, String apikey) throws IOException;
    
}