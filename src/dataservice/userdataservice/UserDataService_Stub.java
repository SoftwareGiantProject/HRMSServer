package dataservice.userdataservice;

import po.ClientPO;
import po.NetsalePO;
import po.NetworkerPO;
import po.WorkerPO;
import util.ResultMessage;

public class UserDataService_Stub implements UserDataService{
	String userid;
	String username;
	String password;
	String contact;
	int credit;
	
	public UserDataService_Stub(String id,String name,String word,int cred,String cont){
		userid=id;
		username=name;
		password=word;
		contact=cont;
		credit=cred;
	}

	@Override
	public ResultMessage add(ClientPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage add(WorkerPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage add(NetsalePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage add(NetworkerPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public WorkerPO findWorker(String id) {
		// TODO Auto-generated method stub
		return new WorkerPO(userid,username,password,contact);
	}

	@Override
	public ClientPO findClient(String id) {
		// TODO Auto-generated method stub
		return new ClientPO(userid,username,password,credit,contact);
	}

	@Override
	public NetsalePO findNetsale(String id) {
		// TODO Auto-generated method stub
		return new NetsalePO(userid,username,password,contact);
	}

	@Override
	public NetworkerPO findNetworker(String id) {
		// TODO Auto-generated method stub
		return new NetworkerPO(userid,username,password,contact);
	}

	@Override
	public ResultMessage modify(ClientPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(WorkerPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(NetsalePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(NetworkerPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ClientPO clientLogin(String id, String password) {
		// TODO Auto-generated method stub
		return new ClientPO(userid,username,password,credit,contact);
	}

	@Override
	public WorkerPO workerLogin(String id, String password) {
		// TODO Auto-generated method stub
		return new WorkerPO(userid,username,password,contact);
	}

	@Override
	public NetsalePO netsaleLogin(String id, String password) {
		// TODO Auto-generated method stub
		return new NetsalePO(userid,username,password,contact);
	}

	@Override
	public NetworkerPO networkerLogin(String id, String password) {
		// TODO Auto-generated method stub
		return new NetworkerPO(userid,username,password,contact);
	}
	

}
