package edu.escuelaing.arep.ASE.app.services.impl;

import edu.escuelaing.arep.ASE.app.services.HTTPmethods;

import java.util.HashMap;
import java.util.Map;

public class HTTPmethodsImpl {

    static Map<String, HTTPmethods> endpoints = new HashMap<>();

    public static void addEndpoint(String endpoint, HTTPmethods method){
        endpoints.put(endpoint,method);


    }

    public static HTTPmethods getMethod(String endpoint){
        return endpoints.get(endpoint);


    }






}
