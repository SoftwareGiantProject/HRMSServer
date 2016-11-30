package data.userdata;

import java.rmi.RemoteException;

import dataservice.userdataservice.WorkerDataService;
import po.WorkerPO;
import util.ResultMessage;

public class WorkerDataServiceMysqlImpl implements WorkerDataService{

	@Override
	public ResultMessage add(WorkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkerPO findWorker(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(WorkerPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean workerExist(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean workerLogin(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
