package dev.evgh.et_cas.api;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpHandlerFactory.registerHandlers(server);

        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }
}