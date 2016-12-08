package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.NetworkerPO;
import util.ResultMessage;

public interface NetworkerDataService extends Remote{

	public NetworkerPO findNetworker(String id)throws RemoteException;
	public ResultMessage modify(NetworkerPO po)throws RemoteException;
	public ResultMessage add(NetworkerPO po)throws RemoteException;
	
}
