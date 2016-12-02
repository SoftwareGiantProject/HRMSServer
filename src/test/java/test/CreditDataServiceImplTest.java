package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.creditdata.CreditDataServiceMysqlImpl;
import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.ResultMessage;

public class CreditDataServiceImplTest {

	private CreditDataService creditDataService;


	@Before
	public void init() throws RemoteException{
		creditDataService = DatabaseFactoryMysqlImpl.getInstance().getCreditData();
	}
	
	@Test
	public void testFind(){
		String user_id = "151250061";
		CreditPO po = null;
		try {
			 po = creditDataService.find(user_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(po.getCredit(),1600);
	}
	
	/**
	@Test
	public void testGetHistoryCredit(){
		String user_id = "151250061";
		
		ArrayList<CreditPO> list = null;
		try {
			list = creditDataService.getHistoryCredit(user_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<CreditPO> listRes = new ArrayList<>();
		CreditPO po1 = new CreditPO();
		CreditPO po2 = new CreditPO();
		
		po1.setId("151250061");
		po1.setCredit(600);
		po1.setTime("2016-11-12");
		po1.setChange(100);
		
		po2.setId("151250061");
		po2.setCredit(700);
		po2.setTime("2016-11-22");
		po2.setChange(100);
		
		listRes.add(po2);
		listRes.add(po1);
		
		assertEquals(list.get(1).getUserId()+list.get(1).getCredit()+list.get(1).getTime()+list.get(1).getChange(),
				     listRes.get(1).getId()+listRes.get(1).getCredit()+listRes.get(1).getTime()+listRes.get(1).getChange());
	}
	*/
	
	/**
	 * 该插入方法已测试成功
	@Test
	public void testModify(){
		CreditPO po = new CreditPO();
		
		po.setId("151250061");
		po.setCredit(700);
		po.setTime("2016-11-22");
		po.setChange(100);
		
		try {
			creditDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
}
