package edu.escuelaing.arep.ASE.app.services;

import java.io.IOException;
import java.util.List;

public interface FileService {

    public List<String> BuildFile(String file) throws IOException;

    public List<String> searchFile(String nameFile) throws IOException;

    public List<String> searchFile(String nameFile,String path) throws IOException;

    public byte[] getImage(String imageName) throws IOException;

    public byte[] getImage(String imageName,String path) throws IOException;
}
