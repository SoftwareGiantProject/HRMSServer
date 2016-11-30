package dataservice.datafactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.ClientDataService;
import dataservice.userdataservice.NetsaleDataService;
import dataservice.userdataservice.NetworkerDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.WorkerDataService;

public interface DataFactory extends Remote {
	
	/**
	 * 数据库的抽象工厂
	 * 每个数据库中都有相同的数据表格
	 * 每个数据表格都有不同的实现
	 * @return
	 */

	public UserDataService getUserData()throws RemoteException;
	
	public MemberDataService getMemberData()throws RemoteException;
	
	public PromotionDataService getPromotionData()throws RemoteException;
	
	public CreditDataService getCreditData()throws RemoteException;
	
	public OrderDataService getOrderData()throws RemoteException;
	
	public HotelDataService getHotelData()throws RemoteException;
	
	public RoomDataService getRoomData()throws RemoteException;
	
	public ClientDataService getClientData()throws RemoteException;
	
	public WorkerDataService getWorkerData()throws RemoteException;
	
	public NetsaleDataService getNetsaleData()throws RemoteException;
	
	public NetworkerDataService getNetworkerData()throws RemoteException;
	
}
