  import java.io.*;
  import java.net.*;
  public class TCPServer {
     public static void main(String argv[]) throws Exception {
		 //Create a listening socket object to listen for a client connection
        ServerSocket listenSocket = new ServerSocket(6789);
        System.out.println("Waiting for client request");

        while (true) {
          //When a connection is requested accept it and provide a connection socket for communication with the client
          Socket connectionSocket = listenSocket.accept();
          System.out.println("Accepted a client request");

          //Attach an input stream to the connection socket
          InputStream inFromClient = connectionSocket.getInputStream();
          //create a byte array to hold data from the input stream
          byte inFromClientByteArray[] = new byte[100];
          //Read the data from the input stream into the byte array
          inFromClient.read(inFromClientByteArray);

          //Create a string from the bytes in the byte array
          String clientSentence = new String(inFromClientByteArray);
          System.out.println("Received from client: " + clientSentence);


          //Capitalise the string
          String capitalisiedSentence = clientSentence.toUpperCase();

          //Create an output stream
          OutputStream outToClient = connectionSocket.getOutputStream();
          //Using the output stream send the capiatalised sentence to the client
          outToClient.write(capitalisiedSentence.getBytes());
          System.out.println("Sending to client : " + capitalisiedSentence);

/* Code for calculating area of a circle
		  Double radius = Double.parseDouble(new String(inFromClientByteArray));
		  System.out.println("radius entered by user is " + radius);
		  Double area = Math.PI*radius*radius;

          //Create an output stream
          OutputStream outToClient = connectionSocket.getOutputStream();
          //Using the output stream send the capiatalised sentence to the client
          //outToClient.write(area.byteValue());
          outToClient.write(area.toString().getBytes());
*/

       }
    }
 }
