package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.WorkerPO;
import util.ResultMessage;

public interface WorkerDataService extends Remote{
	
	public ResultMessage add(WorkerPO po)throws RemoteException;
	public WorkerPO findWorker(String id)throws RemoteException;
	public ArrayList<WorkerPO> getAllWorker()throws RemoteException;
	
	public ResultMessage modify(WorkerPO po)throws RemoteException;
}
