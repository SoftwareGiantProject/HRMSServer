package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.datafactory.DataFactory;
import dataservice.userdataservice.WorkerDataService;
import po.WorkerPO;

public class WorkerDataServiceImplTest {

	WorkerDataService workerDataService;
	
	@Before
	public void init(){
		try {
			workerDataService = DatabaseFactoryMysqlImpl.getInstance().getWorkerData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	@Test add方法已测试成功
	public void testAdd(){
		WorkerPO po = new WorkerPO();
		
		po.setUserId("w00001");
		po.setUserName("WorkerNo1");
		po.setPassword("000000");
		po.setContact("workerno1@163.com");
		
		try {
			workerDataService.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/** find方法已测试成功
	@Test
	public void testFindWorker(){
		String id = "w00001";
		
		WorkerPO po = new WorkerPO();
		
		try {
			po = workerDataService.findWorker(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
		
		assertEquals("WorkerNo1",po.getUserName());
		assertEquals("workerno1@163.com", po.getContact());
	}
	*/
	
	/**
	@Test
	public void testModify(){
		WorkerPO po = new WorkerPO();
		
		po.setUserId("w00001");
		po.setPassword("123456");
		po.setContact("15895870321");
		po.setUserName("WorkerNo1");
		po.setHotel_id("h001");
		
		try {
			workerDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test GetAll方法已测试成功
	public void testGetAllWorker(){
		ArrayList<WorkerPO> list = new ArrayList<>();
		
		try {
			list = workerDataService.getAllWorker();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			
		assertEquals("15895870321", list.get(0).getContact());
		assertEquals("WorkerNo2", list.get(1).getUserName());
	}
	*/
}
