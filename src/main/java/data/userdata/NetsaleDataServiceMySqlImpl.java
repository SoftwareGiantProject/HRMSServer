package data.userdata;

import java.rmi.RemoteException;

import dataservice.userdataservice.NetsaleDataService;
import po.NetsalePO;
import util.ResultMessage;

public class NetsaleDataServiceMySqlImpl implements NetsaleDataService {

	@Override
	public ResultMessage add(NetsalePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetsalePO findNetsale(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetsalePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean netsaleExist(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean netsaleLogin(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
