package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.userdataservice.WorkerDataService;
import po.WorkerPO;
import util.ResultMessage;

public class WorkerDataServiceMysqlImpl extends UnicastRemoteObject  implements WorkerDataService{

	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public WorkerDataServiceMysqlImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage add(WorkerPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<>();
		
		params.add(po.getUserId());
		params.add(po.getHotel_id());
		params.add(po.getUserName());
		params.add(po.getPassword());
		params.add(po.getContact());
		
		String sql = sqlManager.appendSQL("INSERT INTO worker VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public WorkerPO findWorker(String id) throws RemoteException {
		sqlManager.getConnection();
		
		Map<String,Object> map = new HashMap<>();
		
		String sql = "SELECT * FROM worker WHERE id=?";
	
		map = sqlManager.querySimple(sql, new Object[]{id});
		
		WorkerPO po = getWorkerPO(map);
		return po;
	}

	@Override
	public ResultMessage modify(WorkerPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<>();
		
		params.add(po.getPassword());
		params.add(po.getUserName());
		params.add(po.getContact());
		params.add(po.getUserId());
		params.add(po.getHotel_id());
		
		String sql = "UPDATE worker SET password=?, name=?, contact=? WHERE id=? AND hotel_id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<WorkerPO> getAllWorker() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<WorkerPO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM worker";
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String,Object> map : mapList){
			list.add(getWorkerPO(map));
		}
		return list;
	}
	
	private WorkerPO getWorkerPO(Map<String, Object> map){
		WorkerPO po = new WorkerPO();
		
		po.setUserId(map.get("id").toString());
		po.setPassword(map.get("password").toString());
		po.setUserName(map.get("name").toString());
		po.setContact(map.get("contact").toString());
		po.setHotel_id(map.get("hotel_id").toString());
		
		return po;
	}
}
