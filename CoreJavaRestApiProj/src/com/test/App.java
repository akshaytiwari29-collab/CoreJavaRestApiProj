package com.test;
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;


public class App {
	public static void main(String[] args) {
        try {
   
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/api", new ApiHandler());
            server.setExecutor(null); // creates a default executor
            server.start();
            System.out.println("Server started on port 8000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
