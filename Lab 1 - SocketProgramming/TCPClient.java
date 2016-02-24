import java.io.*;
import java.net.*;

  public class TCPClient {
     public static void main(String argv[]) throws Exception {

		System.out.println("Please enter the sentence that the server should capitalise:");
        //Create an input stream and attach it to the keyboard
        InputStream inFromUser = System.in;
        //Create a byte array to hold the user's input
        byte inFromUserByteArray[] = new byte[100];
        //Read the user's input from the input stream into the byte array
        inFromUser.read(inFromUserByteArray);

        //Create a socket object & initiate the TCP connection between client & server
        Socket clientSocket = new Socket("127.0.0.1", 6789);
        //Create an output stream and attach it to the socket object
        OutputStream outToServer = clientSocket.getOutputStream();
        //Write the data in the byte array to the output stream
        outToServer.write(inFromUserByteArray);

        //Create an input stream to read in the server's reply from the socket
        InputStream inFromServer = clientSocket.getInputStream();
        //Create a byte array to hold the server's repsonse
        byte inFromServerByteArray[] = new byte[100];
        //Read the server's response in the input stream into the byte array
        inFromServer.read(inFromServerByteArray);
        //Create a string using the bytes read into the byte array
        String modifiedSentence = new String(inFromServerByteArray);

        //Print the server's reply on the terminal
        System.out.println("Received from server: " + modifiedSentence);
        //Close the socket
        clientSocket.close();

    }
 }
