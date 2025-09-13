package edu.eci.arsw.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer = new byte[256];
        
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4445);
        socket.send(packet);
        
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Hora del servidor: " + received);
        
        socket.close();
    }
}