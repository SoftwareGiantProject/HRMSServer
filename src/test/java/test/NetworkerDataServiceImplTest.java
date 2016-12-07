package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.userdataservice.NetworkerDataService;
import po.NetworkerPO;

public class NetworkerDataServiceImplTest {

	NetworkerDataService networkerDataService;
	
	@Before
	public void init(){
		try {
			networkerDataService = DatabaseFactoryMysqlImpl.getInstance().getNetworkerData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	@Test
	public void testFind(){
		String id = "n001";
		
		NetworkerPO po = new NetworkerPO();
		
		try {
			po = networkerDataService.findNetworker(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("networker",po.getPassword());
		assertEquals("networker@gmail.com", po.getContact());
	}
	*/
	
	/**
	@Test modify方法已测试成功
	public void testModify(){
		NetworkerPO po = new NetworkerPO();
		
		po.setUserId("n001");
		po.setUserName("Networker");
		po.setPassword("itisnetworker");
		po.setContact("Networker@163.com");
		
		try {
			networkerDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
}
