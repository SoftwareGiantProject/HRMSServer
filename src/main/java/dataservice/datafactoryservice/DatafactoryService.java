package dataservice.datafactoryservice;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;

public interface DatafactoryService {

	public UserDataService UserDataServiceImpl();
	
	public MemberDataService MemberDataServiceImpl();
	
	public PromotionDataService PromotionDataServiceImpl();
	
	public CreditDataService CreditDataServiceImpl();
	
	public OrderDataService OrderDataServiceImpl();
	
	public HotelDataService HotelDataServiceImpl();
	
	public RoomDataService RoomDataServiceImpl();
	
}
