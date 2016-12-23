package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;

public interface OrderDataService extends Remote{


	public OrderPO findOrder(String order_id) throws RemoteException;

	public ArrayList<OrderPO> findList(String user_id,String ListType) throws RemoteException;

	public ArrayList<OrderPO> getOrderByHotel(String hotel_id, String ListType) throws RemoteException;

	public ArrayList<OrderPO> getALLOrderByHotel(String hotel_id)throws RemoteException;
	
	public ArrayList<OrderPO> getOrderByHotel(String hotel_id)throws RemoteException;

	public ResultMessage addOrder(OrderPO order) throws RemoteException;

	public ResultMessage undoOrder(OrderPO order) throws RemoteException;

	public ResultMessage modifyOrder(OrderPO order) throws RemoteException;
	
	public ArrayList<OrderPO> getAllOrder() throws RemoteException;
	
	

}