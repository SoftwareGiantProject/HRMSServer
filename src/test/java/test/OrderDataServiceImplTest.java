package test;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.ListType;

public class OrderDataServiceImplTest {

	private OrderDataService orderDataService;
	
	@Before
	public void init(){
		orderDataService = DatabaseFactoryMysqlImpl.getInstance().getOrderDatabase();
	}
	
	@Test
	public void testAddOrder(){
		OrderPO po = new OrderPO();
		
		po.setOrder_id("201611280001");
		po.setUser_id("151250061");
		po.setStartTime("2016-11-27-08-11-54");
		po.setEndTime("2016-11-28-13-06-22");
		po.setDeadline(" ");
		po.setExecuteTime("2016-11-27-12-04-22");
		po.setPeople(1);
		po.setHasChild(false);
		po.setListType(ListType.HISTORYLIST);
		
		try {
			orderDataService.addOrder(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
