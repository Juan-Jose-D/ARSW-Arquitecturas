package edu.eci.arsw.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoServer extends Remote {
    String echo(String message) throws RemoteException;
}