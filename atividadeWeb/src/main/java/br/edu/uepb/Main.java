package br.edu.uepb;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";
    public static HttpServer startServer() {
    final ResourceConfig rc = new ResourceConfig().packages("br.edu.uepb");
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),rc);

    }
    public static void main(String[] args) throws IOException {
    // Main method with server start and stop comands
    }
}


