package edu.escuelaing.arep.ASE.app.ExternalsWebServices.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edu.escuelaing.arep.ASE.app.ExternalsWebServices.ExternalServices;



/**
    *class that implement the logic that get a film.
*/
public class omdbapiConnection implements ExternalServices{

    private static final  String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0" +
    "Chrome/51.0.2704.103 Safari/537.36";
    private URL URL;
    private String apikey;


    /**
    * create  a instance of omdapiConnection
    * @param URL : url of api
    * @param apikey : key that connect with the api
    */
    public omdbapiConnection(String URL, String apikey){
        try {
            this.URL = new URL(URL);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.apikey = apikey; 
    }


    /**
    * method that  get data of film
    * @param query : title of the film
    */
    @Override
    public String getData(String query) throws IOException{
        URL directionFilm = new URL(this.URL + query + "&apikey=" + this.apikey);

        HttpURLConnection con = (HttpURLConnection) directionFilm.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response);

            // print result
            return(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return null;
    }

} 




     

    

