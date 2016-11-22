package dataservice.creditdataservice;

import java.rmi.RemoteException;

import po.CreditPO;
import util.ResultMessage;

public class CreditDataService_Driver {
	public void drive(CreditDataService creditDataService) throws RemoteException{
		CreditPO find1=creditDataService.find("151250004");
		if(find1==new CreditPO()){
			System.out.println("Have find the credit");
		}
		
		ResultMessage res1=creditDataService.modify(new CreditPO());
		if(res1==ResultMessage.SUCCESS){
			System.out.println("Modify Successfully!");
		}
		
	}

}
