package dataservice.datafactory;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;

public interface DataFactory {
	
	/**
	 * 数据库的抽象工厂
	 * 每个数据库中都有相同的数据表格
	 * 每个数据表格都有不同的实现
	 * @return
	 */

	public UserDataService getUserDatabase();
	
	public MemberDataService getMemberDatabase();
	
	public PromotionDataService getPromotionDatabase();
	
	public CreditDataService getCreditDatabase();
	
	public OrderDataService getOrderDatabase();
	
	public HotelDataService getHotelDatabase();
	
	public RoomDataService getRoomDatabase();
	
}
