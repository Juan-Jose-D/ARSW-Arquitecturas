package edu.eci.arsw.RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class EchoServerImpl implements EchoServer {
    
    public EchoServerImpl() throws RemoteException {
        super();
    }
    
    public String echo(String message) throws RemoteException {
        return "Desde el servidor: " + message;
    }
    
    public static void main(String[] args) {
        try {
            System.setSecurityManager(new SecurityManager());
            
            EchoServerImpl server = new EchoServerImpl();
            EchoServer stub = (EchoServer) UnicastRemoteObject.exportObject(server, 0);
            
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("EchoServer", stub);
            
            System.out.println("Servidor RMI listo...");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}