package dataservice.orderdataservice;

import java.util.ArrayList;

import po.*;
import util.*;

public interface OrderDataService {

	
	public OrderPO findOrder(String order_id);
	public ArrayList<OrderPO> findList(String ListType);
	
	public ResultMessage addOrder(OrderPO order);
	public ResultMessage undoOrder(OrderPO order);
	public ResultMessage modifyOrder(OrderPO order);
}
