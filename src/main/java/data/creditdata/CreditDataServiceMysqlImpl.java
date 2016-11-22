package data.creditdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.ResultMessage;

public class CreditDataServiceMysqlImpl implements CreditDataService{
	
//	public static final long serialVersionUID = 2L;
	
	private SqlManager sqlManager = SqlManager.getSqlManager();
	
	public CreditDataServiceMysqlImpl() throws RemoteException {
		super();
	}
	
	@Override
	public CreditPO find(String user_id) throws RemoteException{
		CreditPO po = new CreditPO();
		
		po.setId(user_id);
		
		String sql = "SELECT credit_point FROM credit WHERE client_id=?";
		Map<String, Object> map = sqlManager.querySimple(sql, new Object[]{user_id});
		
		po.setCredit(Integer.parseInt(map.get("credit").toString()));
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
		
		String sql = sqlManager.appendSQL("UPDATE credit SET credit_point=? WHERE client_id=?", params.size());
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<CreditPO> getHistoryCredit(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
