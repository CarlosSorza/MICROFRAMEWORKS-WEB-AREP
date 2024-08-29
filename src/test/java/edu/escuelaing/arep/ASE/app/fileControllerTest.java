package edu.escuelaing.arep.ASE.app;

import edu.escuelaing.arep.ASE.app.controllers.FileController;
import edu.escuelaing.arep.ASE.app.controllers.FilmController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class fileControllerTest {

    FileController fl = null;

    FilmController fm = null;

    @Before
    public void setUp() throws Exception {
        fl = new FileController();

    }



    @Test
    public void whenItDoAGetHtmlItShouldReturnThisFile() throws  IOException {

        List<String> listExpected = new ArrayList<>();



        listExpected.add(new String(Files.readAllBytes(Paths.get("src/main/java/static/file.html"))));

        List<String> listResponse = fl.searchFile("file.html","src/main/java/static/");


        Assert.assertEquals(listExpected,listResponse);
    }

    @Test
    public void whenItDoAGetCSSItShouldReturnThisFile() throws  IOException {

        List<String> listExpected = new ArrayList<>();



        listExpected.add(new String(Files.readAllBytes(Paths.get("src/main/java/static/style.css"))));

        List<String> listResponse = fl.searchFile("style.css","src/main/java/static/");


        Assert.assertEquals(listExpected,listResponse);
    }

    @Test
    public void whenItDoAGetJSItShouldReturnThisFile() throws  IOException {

        List<String> listExpected = new ArrayList<>();



        listExpected.add(new String(Files.readAllBytes(Paths.get("src/main/java/static/file.js"))));

        List<String> listResponse = fl.searchFile("file.js","src/main/java/static/");


        Assert.assertEquals(listExpected,listResponse);
    }

    @Test
    public void whenItDoAGetJPGItShouldReturnThisFile() throws  IOException {

        byte[] listExpected = Files.readAllBytes(Paths.get("src/main/java/static/setup-gaming.jpg"));


        byte[] listResponse = fl.getImage("setup-gaming.jpg","src/main/java/static/");


        Assert.assertArrayEquals(listExpected,listResponse);
    }


}
