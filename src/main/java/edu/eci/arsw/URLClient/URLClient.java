package edu.eci.arsw.URLClient;

import java.io.*;
import java.net.*;

public class URLClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com/");
            
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            
            try (BufferedReader reader = new BufferedReader(
                 new InputStreamReader(url.openStream()))) {
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println(inputLine);
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}