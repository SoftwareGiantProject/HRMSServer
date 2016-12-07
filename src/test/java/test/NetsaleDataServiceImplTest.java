package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.userdataservice.NetsaleDataService;
import po.NetsalePO;

public class NetsaleDataServiceImplTest {

	private NetsaleDataService netsaleDataService;
	
	@Before
	public void init(){
		try {
			netsaleDataService = DatabaseFactoryMysqlImpl.getInstance().getNetsaleData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	@Test add方法已测试成功
	public void testAdd(){
		NetsalePO po = new NetsalePO();
		
		po.setUserId("s001");
		po.setPassword("000000");
		po.setUserName("No.1");
		po.setContact("NetsaleNo1@gmail.com");
		
		try {
			netsaleDataService.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/

	@Test
	public void testFindNetsale(){
		String id = "s001";
		
		NetsalePO po = new NetsalePO();
		
		try {
			po = netsaleDataService.findNetsale(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("NetsaleNo1@gmail.com",po.getContact());
	}
	
	/**
	@Test modift已测试成功
	public void testModify(){
		NetsalePO po = new NetsalePO();
		
		po.setUserId("s001");
		po.setPassword("s001s001");
		po.setUserName("No.1");
		po.setContact("NetsaleNo1@gmail.com");
	
		try {
			netsaleDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
}
