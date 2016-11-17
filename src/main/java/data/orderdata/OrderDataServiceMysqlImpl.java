package data.orderdata;

import dataservice.orderdataservice.OrderDataService;
import po.ListPO;
import po.OrderPO;
import util.ResultMessage;

public class OrderDataServiceMysqlImpl implements OrderDataService{

	@Override
	public OrderPO findOrder(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListPO findList(String ListType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage undoOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return null;
	}

}
