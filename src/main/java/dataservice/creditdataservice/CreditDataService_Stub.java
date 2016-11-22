package dataservice.creditdataservice;

import java.util.ArrayList;

import po.CreditPO;
import util.ResultMessage;

public class CreditDataService_Stub implements CreditDataService{
	/*public CreditPO getCreditData(){
		CreditPO creditPO=new CreditPO();
		return creditPO;
	}*/
	private String userId;
	private int creDit;
	
	 public CreditDataService_Stub(String userid,int credit) {
		// TODO Auto-generated constructor stub
		super();
		this.userId=userid;
		this.creDit=credit;
	}

	@Override
	public CreditPO find(String user_id) {
		// TODO Auto-generated method stub
		return new CreditPO(user_id,this.creDit);
	}

	@Override
	public ResultMessage modify(CreditPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<CreditPO> getHistoryCredit(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
