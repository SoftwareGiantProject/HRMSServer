package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelEvaluationPO;
import po.HotelPO;

public class HotelDataServiceImplTest {

	private HotelDataService hotelDataService;
	
	@Before
	public void init() throws RemoteException{
		hotelDataService = DatabaseFactoryMysqlImpl.getInstance().getHotelData();
	}
	
	@Test
	public void testGetAllHotels(){
		ArrayList<HotelPO> list = new ArrayList<>();
	
		try {
			list = hotelDataService.getAllHotels();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("h001", list.get(0).getHotelId());
		assertEquals(3, list.get(1).getHotelLevel());
	}
	
	@Test
	public void testSeekHotel(){
		String hotel_name = "英尊假日酒店";
		
		HotelPO po = new HotelPO();
 		try {
			po = hotelDataService.seekHotel(hotel_name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
 		
 		assertEquals(po.getHotelId(),"h001");
 		assertEquals(po.getHotelArea(), "栖霞区");
	}
	
	/**
	@Test add方法已测试成功
	
	public void testAddHotel(){
		HotelPO po = new HotelPO();
		
		po.setHotelId("h003");
		po.setHotelName("布丁酒店");
		po.setHotelLevel(3);
		po.setHotelScore(4.2);
		po.setHotelAddress("南京市栖霞区仙林大道154号");
		po.setHotelArea("栖霞区");
		po.setHotelIntro("靠近金鹰奥莱城");
		po.setHotelServe("酒店餐厅，免费停车场，免费wifi，叫醒服务");
		po.setHotelRoom("大床房，标准间，单人间");
		
		try {
			hotelDataService.addHotel(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test 修改方法已测试成功
	public void testModifyHotel(){
		HotelPO po = new HotelPO();
		
		po.setHotelId("h001");
		po.setHotelName("英尊假日酒店");
		po.setHotelLevel(4);
		po.setHotelScore(4.6);
		po.setHotelAddress("南京市栖霞区仙林大道168号");
		po.setHotelArea("栖霞区");
		po.setHotelIntro("靠近仙林大学城");
		po.setHotelServe("酒店餐厅，免费停车场，免费wifi，叫醒服务");
		po.setHotelRoom("大床房，标准间，商务间，豪华套间");
		
		try {
			hotelDataService.modifyHotel(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	
	/**
	 * 评价酒店方法已测试成功
	@Test
	public void testEvaluationHotel(){
		HotelEvaluationPO po = new HotelEvaluationPO();
		
		po.setOrder_id("201611250001");
		po.setUser_id("151250061");
		po.setDate("2016-11-27");
		po.setData("酒店设施很好，服务很周到");
		po.setLevel(5);
		
		try {
			hotelDataService.evaluateHotel(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testGetReservedHotel(){
		String user_id = "151250060";
		
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		
		try{
			list = hotelDataService.getReservedHotel(user_id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		assertEquals("布丁酒店",list.get(0).getHotelName());
	}
	
	@Test
	public void testGetHotelByArea(){
		String area = "栖霞区";
		
		ArrayList<HotelPO> list = new ArrayList<>();
		try {
			list = hotelDataService.getHotelByArea(area);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("英尊假日酒店",list.get(0).getHotelName());
		assertEquals("h002",list.get(1).getHotelId());
		assertEquals("靠近金鹰奥莱城", list.get(2).getHotelIntro());
	}
	
	@Test
	public void testGetHotelByLevel(){
		int level = 3;
		
		ArrayList<HotelPO> list = new ArrayList<>();
		try {
			list = hotelDataService.getHotelByLevel(level);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("莫泰168", list.get(0).getHotelName());
		assertEquals("h003", list.get(1).getHotelId());
 	}
	
	@Test
	public void testGetAllHotelEvaluation(){
		String hotel_name = "英尊假日酒店";
		
		ArrayList<HotelEvaluationPO> list = new ArrayList<>();
		
		try {
			list = hotelDataService.getAllHotelEvaluation(hotel_name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("2016-11-27", list.get(0).getDate());
		assertEquals(5, list.get(0).getLevel());
	}
	
	@Test
	public void testGetAllHotel(){
		String user_id = "151250060";
		String hotel_id = "h003";
		
		ArrayList<HotelPO> list = new ArrayList<>();
		
		try {
			list = hotelDataService.getAllHotel(user_id, hotel_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(3, list.get(0).getHotelLevel());
	}
}


