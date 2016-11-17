package dataservice.creditdataservice;

import po.CreditPO;
import util.ResultMessage;

public class CreditDataService_Driver {
	public void drive(CreditDataService creditDataService){
		CreditPO find1=creditDataService.find("151250004");
		if(find1==new CreditPO()){
			System.out.println("Have find the credit");
		}
		
		ResultMessage res1=creditDataService.modify(new CreditPO());
		if(res1==ResultMessage.SUCCESS){
			System.out.println("Modify Successfully!");
		}
		
		ResultMessage res2=creditDataService.trade(new CreditPO());
		if(res2==ResultMessage.SUCCESS){
			System.out.println("Trade successfully!");
		}
	}

}
