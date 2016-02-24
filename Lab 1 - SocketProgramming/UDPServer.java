  import java.io.*;
  import java.net.*;
  public class UDPServer {
     public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(4444);
        System.out.println("Waiting for client request");
        while (true) {
           byte[] receiveData = new byte[1024];
           DatagramPacket receivePacket =
             new DatagramPacket(receiveData, receiveData.length);
          serverSocket.receive(receivePacket);

          String clientSentence = new String (receivePacket.getData());
          System.out.println("Received from client: " + clientSentence);

          InetAddress IPAddress = receivePacket.getAddress();
          int port = receivePacket.getPort();
          System.out.println("client port is : " + port);
          String capitalisiedSentence = clientSentence.toUpperCase();
          byte[] sendData = new byte[1024];
          sendData = capitalisiedSentence.getBytes();
          DatagramPacket sendPacket =
             new DatagramPacket(sendData, sendData.length,
                IPAddress, port);
          serverSocket.send(sendPacket);
          System.out.println("Sending to client : " + capitalisiedSentence);
       }
    }
 }
