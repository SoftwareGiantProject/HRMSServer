package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

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
	 * 插入酒店方法已测试成功
	@Test
	public void testAddHotel(){
		HotelPO po = new HotelPO();
		
		po.setHotelId("h002");
		po.setHotelName("莫泰168");
		po.setHotelAddress("南京市栖霞区仙林大道254号");
		po.setHotelArea("栖霞区");
		po.setHotelIntro("靠近仙林大学城");
		po.setHotelServe("酒店餐厅，免费停车场，免费wifi，叫醒服务");
		po.setHotelRoom("大床房，标准间");
		
		try {
			hotelDataService.addHotel(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testModifyHotel(){
		HotelPO po = new HotelPO();
		
		po.setHotelId("h001");
		po.setHotelName("英尊假日酒店");
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
}
