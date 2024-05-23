package com.test;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UserHandler implements HttpHandler {
  
	@Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            handleGetRequest(exchange);
        } else {
            handleMethodNotAllowed(exchange);
        }
    }

    private void handleGetRequest(HttpExchange exchange) throws IOException {
        String response = "[{\"id\": 1, \"name\": \"John Doe\"}, {\"id\": 2, \"name\": \"Jane Doe\"}]";
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    private void handleMethodNotAllowed(HttpExchange exchange) throws IOException {
        String response = "Method Not Allowed";
        exchange.sendResponseHeaders(405, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
