package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.ListType;

public class OrderDataServiceImplTest {

	private OrderDataService orderDataService;
	
	@Before
	public void init(){
		orderDataService = DatabaseFactoryMysqlImpl.getInstance().getOrderData();
	}
	
	/**
	 * add方法已测试成功
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
	*/
	
	@Test
	public void testFindOrder(){
		String order_id = "201611270001";
		
		OrderPO po = new OrderPO();
		
		try {
			po = orderDataService.findOrder(order_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(po.getUser_id()+po.getPeople(),"151250061"+1);
	}
	
	/**
	 * undo方法已通过测试
	@Test
	public void testUndoOrder(){
		OrderPO po = new OrderPO();
		
		po.setOrder_id("201611280002");
		po.setUser_id("151250060");
		po.setStartTime("2016-11-27-08-12-32");
		po.setEndTime("2016-11-28-20-53-54");
		po.setDeadline(" ");
		po.setExecuteTime("");
//		po.setPeople(1);
//		po.setHasChild(false);
		po.setListType(ListType.CURRENTLIST);
		
		try {
			orderDataService.undoOrder(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testModifyOrder(){
		OrderPO po = new OrderPO();
		
		po.setOrder_id("201611270002");
		po.setUser_id("151250060");
		po.setHotel_id("h002");
		po.setStartTime("2016-11-27-08-12-32");
		po.setEndTime("2016-11-28-20-53-54");
		po.setDeadline(" ");
		po.setExecuteTime(" ");
		po.setPredictCheckInTime("2016-11-27-20-00-00");
		po.setPredictCheckOutTime("2016-11-28-12-00-00");
		po.setPeople(1);
		po.setHasChild(false);
		po.setListType(ListType.UNDOLIST);
		
		try {
			orderDataService.modifyOrder(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * FindList已测试成功
	@Test
	public void testFindList(){
		String listType1 = "HISTORYLIST";
		String listType2 = "ALLLIST";
		
		ArrayList<OrderPO> list1 = new ArrayList<OrderPO>();
		ArrayList<OrderPO> list2 = new ArrayList<OrderPO>();
		try {
			list1 = orderDataService.findList("1251250061",listType1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			list2= orderDataService.findList("151250060",listType2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(list1.get(1).getOrder_id(), "201611270001");
		assertEquals(list2.get(2).getListType(),ListType.UNDOLIST );
	}
	*/
	
	/**
	@Test 根据酒店id和订单类型获得 list测试成功
	public void testGetOrderByHotel(){
		String hotel_id = "h001";
		String listType = "HISTORYLIST";
		
		ArrayList<OrderPO> list = new ArrayList<>();
		
		try {
			list = orderDataService.getOrderByHotel(hotel_id, listType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("201611250001", list.get(0).getOrder_id());
		assertEquals("2016-11-27-08-11-54",list.get(1).getStartTime());
	}
	*/
}
	