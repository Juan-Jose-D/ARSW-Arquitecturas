package edu.eci.arsw.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoClient {
    public static void main(String[] args) {
        try {
            System.setSecurityManager(new SecurityManager());
            
            Registry registry = LocateRegistry.getRegistry("localhost");
            EchoServer echoServer = (EchoServer) registry.lookup("EchoServer");
            
            String response = echoServer.echo("Hola mundo RMI!");
            System.out.println("Respuesta: " + response);
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}