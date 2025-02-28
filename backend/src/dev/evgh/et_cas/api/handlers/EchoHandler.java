package dev.evgh.et_cas.api.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dev.evgh.et_cas.api.HttpHandlerFactory;
import dev.evgh.et_cas.api.services.Cas;

import java.io.IOException;
import java.io.OutputStream;

public class EchoHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        HttpHandlerFactory.addCORSHeaders(exchange); // Always add CORS headers

        int a = Cas.add(1, 2); // Example of using the business logic

        // Assemble the response.
        StringBuilder response = new StringBuilder();
        exchange.getRequestHeaders().forEach((key, value) -> response.append(key).append(": ").append(String.join(", ", value)).append("\n"));
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
    }
}