package data.userdata;

import dataservice.userdataservice.UserDataService;
import po.ClientPO;
import po.NetsalePO;
import po.NetworkerPO;
import po.WorkerPO;
import util.ResultMessage;

public class UserDataServiceMysqlImpl implements UserDataService{

	@Override
	public ResultMessage add(ClientPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(WorkerPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(NetsalePO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(NetworkerPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkerPO findWorker(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientPO findClient(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetsalePO findNetsale(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetworkerPO findNetworker(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(ClientPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(WorkerPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetsalePO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(NetworkerPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean clientExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean workerExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean netsaleExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean networkerExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clientLogin(String id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean workerLogin(String id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean netsaleLogin(String id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean networkerLogin(String id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
