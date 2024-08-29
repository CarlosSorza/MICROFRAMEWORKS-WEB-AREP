package edu.escuelaing.arep.ASE.app.controllers;

import edu.escuelaing.arep.ASE.app.services.FileService;
import edu.escuelaing.arep.ASE.app.services.impl.FileServicesImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileController {

    FileService fileService;


    public FileController(){

         fileService = new FileServicesImpl();

    }

    public List<String> getFile(String file) throws IOException {
        return fileService.BuildFile(file);


    }


    public List<String> searchFile(String file) throws IOException{

        return fileService.searchFile(file);
    }

    public List<String> searchFile(String file,String path) throws IOException{
        return fileService.searchFile(file,path);
    }

    public byte[] getImage(String imageName) throws IOException{
        return  fileService.getImage(imageName);
    }

    public byte[] getImage(String imageName,String path) throws IOException{
        return  fileService.getImage(imageName,path);
    }



}
