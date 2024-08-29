package edu.escuelaing.arep.ASE.app.controllers;

import static edu.escuelaing.arep.ASE.app.services.impl.HTTPmethodsImpl.addEndpoint;
public class ExampleController {

    public ExampleController(){
        addEndpoint("exampleGET",((request, response) -> {
            return response.responseToString("EXAMPLE GET METHOD WITH THIS MICROFRAMEWORK");
        }));

        addEndpoint("example2GET",((request, response) -> {
            return  response.responseToString("EXAMPLE 2 GET METHOD WITH THIS MICROFRAMEWORK");
        }));
    }
}
