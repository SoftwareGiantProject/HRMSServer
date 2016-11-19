package data.datafactoryMysqlImpl;

import java.rmi.RemoteException;

import data.creditdata.CreditDataServiceMysqlImpl;
import data.hoteldata.HotelDataServiceMysqlImpl;
import data.memberdata.MemberDataServiceMysqlImpl;
import data.orderdata.OrderDataServiceMysqlImpl;
import data.promotiondata.PromotionDataServiceMysqlImpl;
import data.roomdata.RoomDataServiceMysqlImpl;
import data.userdata.UserDataServiceMysqlImpl;
import dataservice.creditdataservice.CreditDataService;
import dataservice.datafactory.*;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;

public class DatabaseFactoryMysqlImpl implements DataFactory{

	CreditDataService creditDatabase = new CreditDataServiceMysqlImpl();
	HotelDataService hotelDatabase =  new HotelDataServiceMysqlImpl();
	MemberDataService memberDatabase =  new MemberDataServiceMysqlImpl();	
	OrderDataService orderDatabase =  new OrderDataServiceMysqlImpl();
	PromotionDataService promotionDatabase =  new PromotionDataServiceMysqlImpl();
	RoomDataService roomDatabase =  new RoomDataServiceMysqlImpl();
	UserDataService userDatabase =  new UserDataServiceMysqlImpl();
	
	
	/**
	 * 单例的唯一实例
	 */
	private static DatabaseFactoryMysqlImpl dataFactory;
	
	
	/**
	 * 构造的私有函数，不能在外部new一个此对象
	 * @throws RemoteException
	 */
	private DatabaseFactoryMysqlImpl() throws RemoteException{
		
	}
	
	/**
	 * 获得该单例
	 * @return
	 */
	public static DatabaseFactoryMysqlImpl getInstance(){
		if(dataFactory == null){
			try{
				dataFactory = new DatabaseFactoryMysqlImpl();
			}catch(RemoteException e){
				e.printStackTrace();
			}
		}
		return dataFactory;
	}
	
	public UserDataService getUserDatabase() {
		return userDatabase;
	}

	public MemberDataService getMemberDatabase() {
		return memberDatabase;
	}

	public PromotionDataService getPromotionDatabase() {
		return promotionDatabase;
	}

	public CreditDataService getCreditDatabase() {
		return creditDatabase;
	}

	public OrderDataService getOrderDatabase() {
		return orderDatabase;
	}

	public HotelDataService getHotelDatabase() {
		return hotelDatabase;
	}

	public RoomDataService getRoomDatabase() {
		return roomDatabase;
	}

}
