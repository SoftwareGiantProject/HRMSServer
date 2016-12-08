package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.userdataservice.NetworkerDataService;
import po.NetworkerPO;
import util.ResultMessage;

public class NetworkerDataServiceMySqlImpl implements NetworkerDataService{

	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public NetworkerDataServiceMySqlImpl() throws RemoteException{
		super();
	}
	
	@Override
	public NetworkerPO findNetworker(String id) throws RemoteException {
		sqlManager.getConnection();
		
		Map<String,Object> map = new HashMap<>();
		
		String sql = "SELECT * FROM networker WHERE id=?";
		
		map = sqlManager.querySimple(sql, new Object[]{id});
		
		NetworkerPO po = getNetworkerPO(map);
		sqlManager.releaseAll();
		return po;
	}

	@Override
	public ResultMessage modify(NetworkerPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<>();
		
		params.add(po.getUserName());
		params.add(po.getContact());
		params.add(po.getPassword());
		params.add(po.getUserId());
		
		String sql = "UPDATE networker SET name=?, contact=?, password=? WHERE id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public ResultMessage add(NetworkerPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<>();
		
		params.add(po.getUserId());
		params.add(po.getUserName());
		params.add(po.getPassword());
		params.add(po.getContact());
		
		String sql = sqlManager.appendSQL("INSERT INTO networker VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	private NetworkerPO getNetworkerPO(Map<String, Object> map){
		NetworkerPO po = new NetworkerPO();
		
		po.setUserId(map.get("id").toString());
		po.setUserName(map.get("name").toString());
		po.setPassword(map.get("password").toString());
		po.setContact(map.get("contact").toString());
		
		return po;
	}

}
