import java.io.*;
import java.net.*;
import java.util.*;

class UDPClient {
    public static void main(String args[]) throws Exception {
        Scanner inFromUser = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        System.out.print("Requesting date and time from server. Press Enter to send request.");
        inFromUser.nextLine();
        String request = "getDateTime";
        sendData = request.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String dateTimeFromServer = new String(receivePacket.getData(), 0, receivePacket.getLength());

        System.out.println("Date and Time from Server: " + dateTimeFromServer);

        clientSocket.close();
    }
}
