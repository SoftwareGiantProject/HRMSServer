package data.creditdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import data.userdata.ClientDataServiceMysqlImpl;
import dataservice.creditdataservice.CreditDataService;
import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import po.CreditPO;
import util.ResultMessage;

public class CreditDataServiceMysqlImpl extends UnicastRemoteObject  implements CreditDataService{
	
//	public static final long serialVersionUID = 2L;
	
	private SqlManager sqlManager = SqlManager.getSqlManager();
	
	public CreditDataServiceMysqlImpl() throws RemoteException {
		super();
	}
	
	@Override
	public int getCredit(String user_id) throws RemoteException {
		CreditPO po = find(user_id);
		return po.getCredit();
	}
	
	@Override
	public CreditPO find(String user_id) throws RemoteException{
		CreditPO po = new CreditPO();
		sqlManager.getConnection();
		
		ArrayList<CreditPO> list;
	    list = getHistoryCredit(user_id);
	    
	    po = list.get(list.size()-1);
	    sqlManager.releaseAll();
		return po;
	}

	@Override
	public ResultMessage modify(CreditPO po) throws RemoteException{
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getId());
		params.add(po.getCredit());
		params.add(po.getTime());
		params.add(po.getChange());
		
		String sql = sqlManager.appendSQL("INSERT INTO credit VALUES ", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<CreditPO> getHistoryCredit(String user_id) throws RemoteException{
		sqlManager.getConnection();
		
		ArrayList<CreditPO> list = new ArrayList<CreditPO>();
		String sql = "SELECT * FROM credit WHERE client_id=? ORDER BY time ASC";
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{user_id});
		for(Map<String, Object> map : mapList){
			list.add(getCreditPO(map));
		}
		
		sqlManager.releaseAll();
		return list;
	}

	private CreditPO getCreditPO(Map<String, Object> map){
		
		CreditPO po = new CreditPO();
		po.setId(map.get("client_id").toString());
		po.setCredit(Integer.parseInt(map.get("credit_point").toString()));
		po.setChange(Integer.parseInt(map.get("change").toString()));
		po.setTime(map.get("time").toString());
		
		return po;
	}

}
