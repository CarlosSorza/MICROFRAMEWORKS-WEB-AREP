package edu.escuelaing.arep.ASE.app.services;

import edu.escuelaing.arep.ASE.app.HTTPObjects.Request;
import edu.escuelaing.arep.ASE.app.HTTPObjects.Response;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface HTTPmethods {

    public String HTTPAction(Request request, Response response) throws IOException;
}
