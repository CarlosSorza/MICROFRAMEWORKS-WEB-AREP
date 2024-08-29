package edu.escuelaing.arep.ASE.app.services.impl;

import edu.escuelaing.arep.ASE.app.services.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileServicesImpl  implements FileService {

    @Override
    public List<String> BuildFile(String nameFile) throws IOException {
        List<String> response = new ArrayList<>();
        response.add("HTTP/1.1 200 OK");
        String contentType = "Content-Type: ";
        if (nameFile.endsWith(".html")) {
            contentType += "text/html";
        } else if (nameFile.endsWith(".css")) {
            contentType += "text/css";
        } else if (nameFile.endsWith(".js")) {
            contentType += "text/javascript";
        } else if (nameFile.endsWith(".jpg")) {
            contentType += "image/jpeg";
        } else if (nameFile.endsWith(".json")) {
            contentType += "application/json";
        }else if(nameFile.endsWith(".root")){
            contentType += "text/html";
        } else{
            contentType += "text/plain";

        }
        response.add(contentType);
        return response;
    }

    @Override
    public List<String> searchFile(String nameFile) throws IOException {
            List<String> response = new ArrayList<>();

            File fileSearcher = new File("/src/main/java/static/" + nameFile);


            if (fileSearcher.exists()) {
                response.add(new String(Files.readAllBytes(Paths.get("AREP02/src/main/java/static/" + nameFile))));

            } else {
                response.add("<h1>this file doesnt exist</h1>");
            }

            return response;
    }


    @Override
    public List<String> searchFile(String nameFile,String path) throws IOException {

        List<String> response = new ArrayList<>();


        File fileSearcher = new File(path + nameFile);


        if (fileSearcher.exists()) {
            response.add(new String(Files.readAllBytes(Paths.get(path + nameFile))));

        } else {
            response.add("<h1>this file doesnt exist</h1>");
        }

        return response;
    }




    @Override
    public byte[] getImage(String imageName) throws IOException {

        File fileSearcher = new File("AREP02/src/main/java/static/" + imageName);


        if (fileSearcher.exists()) {
            return Files.readAllBytes(Paths.get("AREP02/src/main/java/static/" + imageName));


        }
        return Files.readAllBytes(Paths.get("AREP02/src/main/java/static/" + "dog.jpg"));

    }

    @Override
    public byte[] getImage(String imageName, String path) throws IOException {

        File fileSearcher = new File(path + imageName);


        if (fileSearcher.exists()) {
            return Files.readAllBytes(Paths.get(path + imageName));


        }
        return Files.readAllBytes(Paths.get(path + "dog.jpg"));

    }


}



