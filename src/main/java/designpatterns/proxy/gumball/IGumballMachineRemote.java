package designpatterns.proxy.gumball;

import java.rmi.*;
 
public interface IGumballMachineRemote extends Remote {
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public IState getState() throws RemoteException;
}
