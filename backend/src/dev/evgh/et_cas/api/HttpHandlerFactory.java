package dev.evgh.et_cas.api;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import dev.evgh.et_cas.api.handlers.EchoHandler;

public class HttpHandlerFactory {
    public static void registerHandlers(HttpServer server){
        server.createContext("/echo", new EchoHandler()); //Add Handler from Handlers package and map it to an endpoint
        // OTHER HANDLERS FOR OTHER ENDPOINTS GO HERE
    }

    public static void addCORSHeaders(HttpExchange exchange) {
        Headers headers = exchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
    }
}