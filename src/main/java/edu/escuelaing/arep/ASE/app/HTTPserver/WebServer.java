package edu.escuelaing.arep.ASE.app.HTTPserver;

import edu.escuelaing.arep.ASE.app.HTTPObjects.Request;
import edu.escuelaing.arep.ASE.app.HTTPObjects.Response;
import edu.escuelaing.arep.ASE.app.controllers.ExampleController;
import edu.escuelaing.arep.ASE.app.controllers.FileController;
import edu.escuelaing.arep.ASE.app.controllers.FilmController;
import static edu.escuelaing.arep.ASE.app.services.impl.HTTPmethodsImpl.getMethod;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebServer {

    private static WebServer instance;

    public static WebServer getInstance() throws IOException {
        if (instance == null) {
            instance = new WebServer();
        }
        return instance;
    }

    private WebServer() throws IOException {
        initialize();
    }

    public void initialize() throws IOException {
        ServerSocket serverSocket = null;

        FileController fileController = new FileController();
        FilmController filmController = new FilmController();
        ExampleController exampleController = new ExampleController();

        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (!serverSocket.isClosed()) {
            try (Socket clientSocket = serverSocket.accept();
                 OutputStream outputStream = clientSocket.getOutputStream();
                 PrintWriter responseWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader requestReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Ready to receive");

                String inputLine;
                boolean isFirstLine = true;
                String filePath = "";
                List<String> responseContent = new ArrayList<>();
                List<String> headers = new ArrayList<>();
                String method = "";
                String query = "";
                String host = "";

                while ((inputLine = requestReader.readLine()) != null) {
                    System.out.println("Received: " + inputLine);

                    if (isFirstLine) {
                        method = inputLine.split("/")[0].split(" ")[0];
                        query = inputLine.split("/")[1].split(" ")[0];
                        filePath = inputLine.split("/")[1].split("\\?")[0].split(" ")[0];
                        isFirstLine = false;
                    } else if (inputLine.contains("Host")) {
                        host = inputLine.split(" ")[1];
                    }

                    if (!requestReader.ready()) {
                        break;
                    }
                }

                String endpoint = filePath + method;
                String url = "http://" + host + "/" + query;
                System.out.println(getMethod(endpoint));

                if (getMethod(endpoint) != null) {
                    headers = fileController.getFile("rta.json");
                    String jsonResponse = getMethod(endpoint).HTTPAction(new Request(new URL(url)), new Response());
                    headers.add("Content-Length: " + jsonResponse.length());
                    responseContent.add(jsonResponse);
                } else if (filePath.endsWith(".jpg")) {
                    headers = fileController.getFile(filePath);
                    for (String header : headers) {
                        responseWriter.println(header);
                    }
                    responseWriter.println();
                    byte[] imageData = fileController.getImage(filePath, "src/main/java/static/");
                    outputStream.write(imageData);
                } else if (!filePath.isEmpty()) {
                    headers = fileController.getFile(filePath);
                    responseContent = fileController.searchFile(filePath, "src/main/java/static/");
                } else {
                    headers = fileController.getFile("rta.root");
                    String rootResponse = "<h1>THIS IS A ROOT PAGE OF SERVER</h1>";
                    responseContent.add(rootResponse);
                }

                if (!filePath.endsWith(".jpg")) {
                    for (String header : headers) {
                        responseWriter.println(header);
                    }
                    responseWriter.println();
                    for (String content : responseContent) {
                        System.out.println(content);
                        responseWriter.println(content);
                    }
                }
            } catch (IOException e) {
                System.out.println("Couldn't listen on port: 32000");
                System.exit(1);
            }
        }
    }
}
