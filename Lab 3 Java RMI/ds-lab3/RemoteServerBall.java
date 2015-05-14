import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class RemoteServerBall implements RemoteServerBallInterface {

  public String hit(int nofTimes) {
    System.out.println("Server has received a remote invocation for the hit method from a client program requesting that the ball be hit "+nofTimes + " times");
    String result = "Hello client - your ball has been hit remotely " +nofTimes + " times";
    return result;
  }

   public void displayMessage(){
	   System.println("Hello, this is second method being caled by the Client");
	   return 0;
            }

  public static void main(String args[]) {
    try {
      RemoteServerBall remoteObj = new RemoteServerBall();
      RemoteServerBallInterface stub = (RemoteServerBallInterface) UnicastRemoteObject.exportObject(remoteObj, 0);
      Registry registry = LocateRegistry.getRegistry();
      registry.bind("ServerBall", stub);
      System.err.println("Server is waiting for client requests!");
    } catch (Exception e) {
      System.err.println("Server exception: " + e.toString());
      e.printStackTrace();
    }
  }
}
