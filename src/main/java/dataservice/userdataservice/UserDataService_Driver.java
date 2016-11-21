package dataservice.userdataservice;

import po.ClientPO;
import po.NetsalePO;
import po.NetworkerPO;
import po.WorkerPO;
import util.ResultMessage;

public class UserDataService_Driver {
	public void drive(UserDataService userDataService){
		ResultMessage res1=userDataService.add(new ClientPO());
		if(res1==ResultMessage.SUCCESS){
			System.out.println("Add Successfully!");
		}
		
		ResultMessage res2=userDataService.add(new WorkerPO());
		if(res2==ResultMessage.SUCCESS){
			System.out.println("Add Successfully!");
		}
		
		ResultMessage res3=userDataService.add(new NetsalePO());
		if(res3==ResultMessage.SUCCESS){
			System.out.println("Add Successfully!");
		}
		
		ResultMessage res4=userDataService.add(new NetworkerPO());
		if(res4==ResultMessage.SUCCESS){
			System.out.println("Add Successfully!");
		}
		
		WorkerPO fWorkerPO=userDataService.findWorker("151250001");
		if(fWorkerPO==new WorkerPO()){
			System.out.println("Find.");
		}
		
		ClientPO fClientPO=userDataService.findClient("151250002");
		if(fClientPO==new ClientPO()){
			System.out.println("Find.");
		}
		
		NetsalePO fNetsalePO=userDataService.findNetsale("151250003");
		if(fNetsalePO==new NetsalePO()){
			System.out.println("Find.");
		}
		
		NetworkerPO fNetworkerPO=userDataService.findNetworker("151250004");
		if(fNetworkerPO==new NetworkerPO()){
			System.out.println("Find.");
		}
		
		ResultMessage res5=userDataService.modify(new ClientPO());
		if(res5==ResultMessage.SUCCESS){
			System.out.println("Modify Successfully!");
		}
		
		ResultMessage res6=userDataService.modify(new WorkerPO());
		if(res6==ResultMessage.SUCCESS){
			System.out.println("Modify Successfully!");
		}
		
		ResultMessage res7=userDataService.modify(new NetsalePO());
		if(res7==ResultMessage.SUCCESS){
			System.out.println("Modify Successfully!");
		}
		
		ResultMessage res8=userDataService.modify(new NetworkerPO());
		if(res8==ResultMessage.SUCCESS){
			System.out.println("Modify Successfully!");
		}
		
	}

}
