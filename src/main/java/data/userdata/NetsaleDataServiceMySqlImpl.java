package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.userdataservice.NetsaleDataService;
import po.NetsalePO;
import util.ResultMessage;

public class NetsaleDataServiceMySqlImpl implements NetsaleDataService {

	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public NetsaleDataServiceMySqlImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage add(NetsalePO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<>();
		
		params.add(po.getUserId());
		params.add(po.getUserName());
		params.add(po.getPassword());
		params.add(po.getContact());

		String sql = sqlManager.appendSQL("INSERT INTO netsale VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public NetsalePO findNetsale(String id) throws RemoteException {
		sqlManager.getConnection();
		
		Map<String,Object> map = new HashMap<>();
		String sql = "SELECT * FROM netsale WHERE id=?";
		
		map = sqlManager.querySimple(sql, new Object[]{id});
		
		NetsalePO po = getNetsalePO(map);
		return po;
	}

	@Override
	public ResultMessage modify(NetsalePO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<>();
		
		params.add(po.getPassword());
		params.add(po.getUserName());
		params.add(po.getContact());
		params.add(po.getUserId());
		
		String sql = "UPDATE netsale SET password=?, name=?, contact=? WHERE id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<NetsalePO> getAllNetsale() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<NetsalePO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM netsale";
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String,Object> map : mapList){
			list.add(getNetsalePO(map));
		}
		sqlManager.releaseAll();
		return list;
	}
	
	private NetsalePO getNetsalePO(Map<String, Object> map){
		NetsalePO po = new NetsalePO();
		
		po.setUserId(map.get("id").toString());
		po.setPassword(map.get("password").toString());
		po.setUserName(map.get("name").toString());
		po.setContact(map.get("contact").toString());
		
		return po;
	}

}
