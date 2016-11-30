package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.WorkerPO;
import util.ResultMessage;

public interface WorkerDataService extends Remote{
	
	public ResultMessage add(WorkerPO po)throws RemoteException;
	public WorkerPO findWorker(String id)throws RemoteException;
	
	public ResultMessage modify(WorkerPO po)throws RemoteException;
	public boolean workerExist(String id)throws RemoteException;
	public boolean workerLogin(String id,String password)throws RemoteException;
}
