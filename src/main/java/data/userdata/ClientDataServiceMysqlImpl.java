package data.userdata;

import java.rmi.RemoteException;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import util.MemberType;
import util.ResultMessage;

public class ClientDataServiceMysqlImpl implements ClientDataService{

	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public ClientDataServiceMysqlImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage add(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientPO findClient(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean clientExist(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clientLogin(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	private ClientPO getClientPO(Map<String, Object> map){
		
		ClientPO po = new ClientPO();
		po.setUserId(map.get("id").toString());
		po.setUserName(map.get("name").toString());
		po.setMemberId(map.get("member_id").toString());
		po.setPassword(map.get("password").toString());
		po.setCredit(Integer.parseInt(map.get("credit").toString()));
		po.setContact(map.get("contact").toString());
		po.setBirthday(map.get("birthday").toString());
		
		String membertype = map.get("membertype").toString();
		switch(membertype){
		case"NONE":
			po.setType(MemberType.NONE);
			break;
		
		case"COM":
			po.setType(MemberType.COMMONMEMBER);
			break;
			
		case"COR":
			po.setType(MemberType.CORPORATEMEMBER);
			break;
		}
		
		return po;
	}
}
