package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.NetsalePO;
import util.ResultMessage;

public interface NetsaleDataService extends Remote{

	public ResultMessage add(NetsalePO po)throws RemoteException;
	public NetsalePO findNetsale(String id)throws RemoteException;
	public ResultMessage modify(NetsalePO po)throws RemoteException;
	
}
