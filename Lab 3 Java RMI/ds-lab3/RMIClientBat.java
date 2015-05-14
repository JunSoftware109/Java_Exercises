import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClientBat {
  public static void main(String[] args) {
    String host = "147.252.238.87";
    try {
      Registry registry = LocateRegistry.getRegistry(host);
      RemoteServerBallInterface stubForRemoteBall = (RemoteServerBallInterface) registry.lookup("ServerBall");

      System.out.println("How many times do you want to hit the server ball?");
      System.out.println("" + displayMessage());
      Scanner input = new Scanner(System.in);
      int nofHits = input.nextInt();
      System.out.println("response from server: " + stubForRemoteBall.hit(nofHits));
    } catch (Exception e) {
      System.err.println("Client exception: " + e.toString());
      e.printStackTrace();
    }
  }
}
