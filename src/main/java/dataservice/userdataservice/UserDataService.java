package dataservice.userdataservice;

import java.awt.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.*;
import util.*;

public interface UserDataService extends Remote{

	public ResultMessage add(ClientPO po)throws RemoteException;
	public ResultMessage add(WorkerPO po)throws RemoteException;
	public ResultMessage add(NetsalePO po)throws RemoteException;
	public ResultMessage add(NetworkerPO po)throws RemoteException;
	
	public WorkerPO findWorker(String id)throws RemoteException;
	public ClientPO findClient(String id)throws RemoteException;
	public NetsalePO findNetsale(String id)throws RemoteException;
	public NetworkerPO findNetworker(String id)throws RemoteException;
	
	public ResultMessage modify(ClientPO po)throws RemoteException;
	public ResultMessage modify(WorkerPO po)throws RemoteException;
	public ResultMessage modify(NetsalePO po)throws RemoteException;
	public ResultMessage modify(NetworkerPO po)throws RemoteException;
	
	public boolean clientExist(String id)throws RemoteException;
	public boolean workerExist(String id)throws RemoteException;
	public boolean netsaleExist(String id)throws RemoteException;
	public boolean networkerExist(String id)throws RemoteException;
	
	public boolean clientLogin(String id,String password)throws RemoteException;
	public boolean workerLogin(String id,String password)throws RemoteException;
	public boolean netsaleLogin(String id,String password)throws RemoteException;
	public boolean networkerLogin(String id,String password)throws RemoteException;
	
}
