package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;

public interface OrderDataService {

	
	public OrderPO findOrder(String order_id) throws RemoteException;
	public ArrayList<OrderPO> findList(String ListType) throws RemoteException;
	
	public ResultMessage addOrder(OrderPO order) throws RemoteException;
	public ResultMessage undoOrder(OrderPO order) throws RemoteException;
	public ResultMessage modifyOrder(OrderPO order) throws RemoteException;
}
