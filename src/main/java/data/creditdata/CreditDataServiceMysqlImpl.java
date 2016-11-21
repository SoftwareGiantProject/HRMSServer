package data.creditdata;

import data.sqlmanager.SqlManager;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.ResultMessage;

public class CreditDataServiceMysqlImpl implements CreditDataService{
	
	SqlManager sqlManager = SqlManager.getSqlManager();
	
	
	@Override
	public CreditPO find(String user_id) {
		return null;
	}

	@Override
	public ResultMessage modify(CreditPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
