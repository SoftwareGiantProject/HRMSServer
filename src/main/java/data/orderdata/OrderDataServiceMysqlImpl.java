package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.orderdataservice.OrderDataService;
import po.ListPO;
import po.OrderPO;
import util.ListType;
import util.ResultMessage;

public class OrderDataServiceMysqlImpl extends UnicastRemoteObject  implements OrderDataService{

	public OrderDataServiceMysqlImpl() throws RemoteException {
		super();
	}


	SqlManager sqlManager = SqlManager.getSqlManager();
	
	@Override
	public OrderPO findOrder(String order_id) throws RemoteException {
		sqlManager.getConnection();
		
		Map<String, Object> map  = new HashMap<String, Object>();
		String sql = "SELECT * FROM orders WHERE order_id=?";
		map = sqlManager.querySimple(sql, new Object[]{order_id});
		
		OrderPO po = getOrderPO(map);
		return po;
	}

	@Override
	public ResultMessage addOrder(OrderPO order) throws RemoteException {
		if(order == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object>  params  = new ArrayList<Object>();
		
		params.add(order.getOrder_id());
		params.add(order.getUser_id());
		params.add(order.getStartTime());
		params.add(order.getEndTime());
		params.add(order.getDeadline());
		params.add(order.getExecuteTime());
		params.add(order.getPeople());
		params.add(order.isHasChild());
		params.add(order.getListType().toString());
		
		String sql = sqlManager.appendSQL("INSERT INTO orders VALUES", params.size());

		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage undoOrder(OrderPO order) throws RemoteException {
		if(order == null)
			return ResultMessage.FAIL;
		
		if(!order.getListType().equals(ListType.CURRENTLIST))
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		

		List<Object> params = new ArrayList<Object>();
		
		params.add(order.getUser_id());
		params.add(order.getStartTime());
		params.add(order.getEndTime());
		params.add(order.getDeadline());
		params.add(order.getExecuteTime());
		params.add(order.getPeople());
		params.add(order.isHasChild());
		params.add("UNDOLIST");
		params.add(order.getOrder_id());
		
		String sql = "UPDATE orders SET user_id=?,startTime=?,endTime=?,deadline=?,executeTime=?,people=?,child=?,listType=? WHERE order_id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyOrder(OrderPO order) throws RemoteException {
		if(order == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(order.getUser_id());
		params.add(order.getStartTime());
		params.add(order.getEndTime());
		params.add(order.getDeadline());
		params.add(order.getExecuteTime());
		params.add(order.getPeople());
		params.add(order.isHasChild());
		params.add(order.getListType().toString());
		params.add(order.getOrder_id());
		
		String sql = "UPDATE order SET user_id=?,startTime=?,endTime=?,deadline=?,executeTime=?,people=?,child=?,listType=? WHERE order_id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<OrderPO> findList(String ListType) throws RemoteException {
		
		switch(ListType){
		case"ALLLIST":{
			sqlManager.getConnection();
			
			ArrayList<OrderPO> list = new ArrayList<OrderPO>();
			String sql = "SELECT * FROM orders ORDER BY order_id DESC";
			List<Map<String , Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
			for(Map<String , Object> map : mapList){
				list.add(getOrderPO(map));
			}
			sqlManager.releaseAll();
			return list;
		}
		
		case"HISTORYLIST":{
			sqlManager.getConnection();
			
			ArrayList<OrderPO> list = new ArrayList<OrderPO>();
			String sql = "SELECT * FROM orders WHERE listType='HISTORYLIST' ORDER BY order_id DESC";
			List<Map<String , Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
			for(Map<String , Object> map : mapList){
				list.add(getOrderPO(map));
			}
			sqlManager.releaseAll();
			return list;
		}
		
		case"CURRENTLIST":{
			sqlManager.getConnection();
			
			ArrayList<OrderPO> list = new ArrayList<OrderPO>();
			String sql = "SELECT * FROM orders WHERE listType='CURRENTLIST' ORDER BY order_id DESC";
			List<Map<String , Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
			for(Map<String , Object> map : mapList){
				list.add(getOrderPO(map));
			}
			sqlManager.releaseAll();
			return list;
		}
		
		case"UNDOLIST":{
			sqlManager.getConnection();
			
			ArrayList<OrderPO> list = new ArrayList<OrderPO>();
			String sql = "SELECT * FROM orders WHERE listType='UNDOLIST' ORDER BY order_id DESC";
			List<Map<String , Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
			for(Map<String , Object> map : mapList){
				list.add(getOrderPO(map));
			}
			sqlManager.releaseAll();
			return list;
		}
		
		case"ABNORMALLIST":{
			sqlManager.getConnection();
			
			ArrayList<OrderPO> list = new ArrayList<OrderPO>();
			String sql = "SELECT * FROM orders WHERE listType='ABNORMALLIST' ORDER BY order_id DESC";
			List<Map<String , Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
			for(Map<String , Object> map : mapList){
				list.add(getOrderPO(map));
			}
			sqlManager.releaseAll();
			return list;
		}
		
		default:
			return null;
		}
	}

	
	private OrderPO getOrderPO(Map<String, Object> map){
		OrderPO po = new OrderPO();
		
		po.setOrder_id(map.get("order_id").toString());
		po.setUser_id(map.get("user_id").toString());
		po.setStartTime(map.get("startTime").toString());
		po.setEndTime(map.get("endTime").toString());
		po.setDeadline(map.get("deadline").toString());
		po.setExecuteTime(map.get("executeTime").toString());
		po.setPeople(Integer.parseInt(map.get("people").toString()));
		po.setHasChild(Boolean.getBoolean(map.get("child").toString()));
		
		String listType = map.get("listType").toString();
		switch(listType){
		case"ALLLIST":
			po.setListType(ListType.ALLLIST);
			break;
		case"HISTORYLIST":
			po.setListType(ListType.HISTORYLIST);
			break;
		case"CURRENTLIST":
			po.setListType(ListType.CURRENTLIST);
			break;
		case"UNDOLIST":
			po.setListType(ListType.UNDOLIST);
			break;
		case"ABNORMALLIST":
			po.setListType(ListType.ABNORMALLIST);
			break;
		}
		
		return po;
	}
}
