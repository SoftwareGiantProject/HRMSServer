package data.userdata;

import java.rmi.RemoteException;

import dataservice.userdataservice.NetworkerDataService;
import po.NetworkerPO;
import util.ResultMessage;

public class NetworkerDataServiceMySqlImpl implements NetworkerDataService{

	@Override
	public ResultMessage add(NetworkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetworkerPO findNetworker(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetworkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean networkerExist(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean networkerLogin(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
