package RemoteRMIVersion;

import java.rmi.*;

public interface RemoteServerBallInterface extends Remote {
	public String hit(int n) throws java.rmi.RemoteException;
}
