  import java.io.*;
  import java.net.*;
  public class UDPClient {
     public static void main(String args[]) throws Exception {
       System.out.println("Please enter the sentence that the server should capitalise: ");

       InputStream inFromUser = System.in;
       byte sendDataByteArray[] = new byte[1024];
       inFromUser.read(sendDataByteArray);

       InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
       DatagramPacket sendPacket =
          new DatagramPacket(sendDataByteArray, sendDataByteArray.length,
             IPAddress, 4444);
       DatagramSocket clientSocket = new DatagramSocket();
       clientSocket.send(sendPacket);

       byte[] receiveData = new byte[1024];
       DatagramPacket receivePacket =
          new DatagramPacket(receiveData, receiveData.length);
       clientSocket.receive(receivePacket);
       String modifiedSentence =
          new String(receivePacket.getData());
       System.out.println("Recieved from server: " + modifiedSentence);
       clientSocket.close();
    }
 }
