package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientPO;
import util.ResultMessage;

public interface ClientDataService extends Remote{

	public ResultMessage add(ClientPO po)throws RemoteException;
	public ClientPO findClient(String id)throws RemoteException;
	public ResultMessage modify(ClientPO po)throws RemoteException;
	public boolean clientExist(String id)throws RemoteException;
	public boolean clientLogin(String id,String password)throws RemoteException;
}
