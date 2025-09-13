package edu.eci.arsw.HTTP;

import java.io.*;
import java.net.*;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Servidor HTTP iniciado en puerto 8080...");
        
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Leer request completa
                StringBuilder requestBuilder = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null && !line.isEmpty()) {
                    requestBuilder.append(line).append("\n");
                }
                String request = requestBuilder.toString();
                System.out.println("Request:\n" + request);

                // Parsear método
                String method = "";
                if (!request.isEmpty()) {
                    String[] parts = request.split(" ");
                    if (parts.length > 0) {
                        method = parts[0];
                    }
                }

                String body = "<html><body><h1>Hola desde el servidor HTTP!</h1>"
                        + "<p>Metodo: " + method + "</p>"
                        + "<pre>" + request + "</pre>"
                        + "</body></html>";

                String response = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html; charset=UTF-8\r\n"
                        + "Connection: close\r\n"
                        + "Content-Length: " + body.getBytes().length + "\r\n"
                        + "\r\n"
                        + body;

                out.println(response);
                out.flush();
                out.close();
                in.close();
                clientSocket.close();
            } catch (Exception e) {
                System.err.println("Error al procesar la petición: " + e.getMessage());
                if (clientSocket != null && !clientSocket.isClosed()) {
                    try { clientSocket.close(); } catch (IOException ex) { }
                }
            }
        }
    }
}