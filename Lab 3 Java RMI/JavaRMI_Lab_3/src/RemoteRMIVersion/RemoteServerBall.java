package RemoteRMIVersion;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerBall implements RemoteServerBallInterface {

  @Override
  public String hit(int nofTimes) {
    System.out.println("Server has received a remote invocation for the hit method from a client program requesting that the ball be hit "+nofTimes + " times");
    String result = "Hello client - your ball has been hit remotely " +nofTimes + " times";
    return result;
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
