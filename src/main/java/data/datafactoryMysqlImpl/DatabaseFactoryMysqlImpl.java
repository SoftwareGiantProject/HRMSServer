package data.datafactoryMysqlImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.creditdata.CreditDataServiceMysqlImpl;
import data.hoteldata.HotelDataServiceMysqlImpl;
import data.memberdata.MemberDataServiceMysqlImpl;
import data.orderdata.OrderDataServiceMysqlImpl;
import data.promotiondata.PromotionDataServiceMysqlImpl;
import data.roomdata.RoomDataServiceMysqlImpl;
import data.userdata.ClientDataServiceMysqlImpl;
import data.userdata.LoginInImpl;
import data.userdata.NetsaleDataServiceMySqlImpl;
import data.userdata.NetworkerDataServiceMySqlImpl;
import data.userdata.UserDataServiceMysqlImpl;
import data.userdata.WorkerDataServiceMysqlImpl;
import dataservice.creditdataservice.CreditDataService;
import dataservice.datafactory.*;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.ClientDataService;
import dataservice.userdataservice.LoginIn;
import dataservice.userdataservice.NetsaleDataService;
import dataservice.userdataservice.NetworkerDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.WorkerDataService;
import po.ClientPO;
import util.ResultMessage;

public class DatabaseFactoryMysqlImpl extends UnicastRemoteObject implements DataFactory,Serializable{

	
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
	
	private CreditDataService creditDatabase = new CreditDataServiceMysqlImpl();
	private HotelDataService hotelDatabase =  new HotelDataServiceMysqlImpl();
	private MemberDataService memberDatabase =  new MemberDataServiceMysqlImpl();	
	private OrderDataService orderDatabase =  new OrderDataServiceMysqlImpl();
	private PromotionDataService promotionDatabase =  new PromotionDataServiceMysqlImpl();
	private RoomDataService roomDatabase =  new RoomDataServiceMysqlImpl();
	private UserDataService userDatabase =  new UserDataServiceMysqlImpl();
	private ClientDataService clientDatabase = new ClientDataServiceMysqlImpl();
	private WorkerDataService workerDatabase = new WorkerDataServiceMysqlImpl();
	private NetsaleDataService netsaleDatabase = new NetsaleDataServiceMySqlImpl();
	private NetworkerDataService networkerDatabase = new NetworkerDataServiceMySqlImpl();
	private LoginIn loginDatabase = new LoginInImpl();
	
	public UserDataService getUserData() {
		return userDatabase;
	}

	public MemberDataService getMemberData() {
		return memberDatabase;
	}

	public PromotionDataService getPromotionData() {
		return promotionDatabase;
	}

	public CreditDataService getCreditData() {
		return creditDatabase;
	}

	public OrderDataService getOrderData() {
		return orderDatabase;
	}

	public HotelDataService getHotelData() {
		return hotelDatabase;
	}

	public RoomDataService getRoomData() {
		return roomDatabase;
	}

	public ClientDataService getClientData() throws RemoteException {
		return clientDatabase;
	}

	public WorkerDataService getWorkerData() throws RemoteException {
		return workerDatabase;
	}

	public NetsaleDataService getNetsaleData() throws RemoteException {
		return netsaleDatabase;
	}

	public NetworkerDataService getNetworkerData() throws RemoteException {
		return networkerDatabase;
	}

	public LoginIn getLoginData() throws RemoteException {
		return loginDatabase;
	}

}
