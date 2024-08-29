package edu.escuelaing.arep.ASE.app.controllers;

import java.io.IOException;
import java.util.ArrayList;

import edu.escuelaing.arep.ASE.app.services.FilmService;
import edu.escuelaing.arep.ASE.app.services.impl.FilmServiceImpl;
import static edu.escuelaing.arep.ASE.app.services.impl.HTTPmethodsImpl.addEndpoint;





/**
 * this class is a controller of app, responsible for providing the service about  films.
 */

public class FilmController {

    private FilmService fm;


    /**
    * Create  instance of FilmController.
    */
    public FilmController(){
        fm = new FilmServiceImpl();
        addEndpoint("filmsGET",(request,response) -> {
            return response.responseToString(fm.getFilmByTitle(request.getParam("film"), "http://www.omdbapi.com/?t=", "c45e3292"));
        });
        addEndpoint("filmsPOST",(request,response) -> {
            return response.responseToString("POST METHOD DIDN'T IMPLEMENTED YET");
        });

    }




    
}
