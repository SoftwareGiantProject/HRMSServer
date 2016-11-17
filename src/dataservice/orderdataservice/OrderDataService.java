package dataservice.orderdataservice;

import po.*;
import util.*;

public interface OrderDataService {

	
	public OrderPO findOrder(String order_id);
	public ListPO findList(String ListType);
	
	public ResultMessage addOrder(OrderPO order);
	public ResultMessage undoOrder(OrderPO order);
	public ResultMessage modifyOrder(OrderPO order);
}
