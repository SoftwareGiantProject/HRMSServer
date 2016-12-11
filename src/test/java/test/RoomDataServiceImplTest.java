package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.datafactory.DataFactory;
import dataservice.roomdataservice.RoomDataService;
import po.RoomConditionDatePO;
import po.RoomPO;
import util.RoomCondition;

public class RoomDataServiceImplTest {

	private RoomDataService roomDataService;
	
	@Before
	public void init(){
		roomDataService = DatabaseFactoryMysqlImpl.getInstance().getRoomData();
	}
	
	/**
	 * add方法已测试通过
	@Test
	public void testAdd(){
		RoomPO po = new RoomPO();
		
		po.setHotel_id("h001");
		po.setRoom_number("007");
		po.setRoom_type("商务间");
		po.setRoom_price(300);
		po.setRoom_condition(RoomConditon.UNRESERVED);
		
		try {
			roomDataService.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testFindRoom(){
		String hotel_id = "h001";
		String room_type = "商务间";
		
		ArrayList<RoomPO> list = new ArrayList<>();
		
		try {
			list = roomDataService.findRoom(hotel_id, room_type);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("005",list.get(0).getRoom_number());
		assertEquals(300, list.get(1).getRoom_price());
		assertEquals(3, list.size());
		
	}
	
	@Test
	public void testGetAllRoom(){
		String hotel_id = "h003";
		
		ArrayList<RoomPO> list = new ArrayList<>();
		try {
			list = roomDataService.getAllRoom(hotel_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(6, list.size());
		assertEquals("大床房",list.get(0).getRoom_type());
	}

	/**
	@Test  add方法已测试成功
	public void testAddRoomCondition(){
		RoomConditionDatePO po = new RoomConditionDatePO();
		
		po.setHotel_id("h001");
		po.setRoomCondition(RoomConditon.UNRESERVED);
		po.setRoomDate("2016-12-7");
		po.setRoomNumber("001");
		
		try {
			roomDataService.addRoomCondition(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test modify测试成功
	public void testModifyRoomCondition(){
		RoomConditionDatePO po = new RoomConditionDatePO();
		
		po.setHotel_id("h001");
		po.setRoomDate("2016-12-7");
		po.setRoomNumber("001");
		po.setRoomCondition(RoomConditon.RESERVED);
		
		try {
			roomDataService.modifyRoomCondition(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/** delete 方法测试成功
	@Test
	public void testDeleteRoomCondition(){
		RoomConditionDatePO po = new RoomConditionDatePO();
		
		po.setHotel_id("h002");
		po.setRoomDate("2016-12-7");
		po.setRoomNumber("002");
		po.setRoomCondition(RoomConditon.RESERVED);
		
		try {
			roomDataService.deleteRoomCondition(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/

	@Test
	public void testGetAllByDate(){
		String date = "2016-12-7";
		ArrayList<RoomConditionDatePO> list = new ArrayList<>();
		
		try {
			list = roomDataService.getAllByDate(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(RoomCondition.CHECKIN, list.get(1).getRoomCondition());
		assertEquals(RoomCondition.RESERVED, list.get(0).getRoomCondition());
	}
	
	/**
	@Test 修改房间信息 测试成功
	public void testModifyRoom(){
		RoomPO po = new RoomPO();
		
		po.setHotel_id("h001");
		po.setRoom_number("001");
		po.setRoom_price(180);
		po.setRoom_condition(RoomCondition.CHECKIN);
		
		try {
			roomDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test 获得所有房间测试成功
	public void testGetAllRooms(){
		ArrayList<RoomPO> list = new ArrayList<>();
		
		try {
			list = roomDataService.getAllRooms();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(18, list.size());
	}
	*/
}

