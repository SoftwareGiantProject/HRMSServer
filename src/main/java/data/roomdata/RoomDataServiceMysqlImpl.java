package data.roomdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mysql.fabric.xmlrpc.base.Array;

import data.sqlmanager.SqlManager;
import dataservice.roomdataservice.RoomDataService;
import po.RoomConditionDatePO;
import po.RoomPO;
import util.ResultMessage;
import util.RoomCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomDataServiceMysqlImpl extends UnicastRemoteObject  implements RoomDataService{

	
	private SqlManager sqlManager = SqlManager.getSqlManager();
	
	public  RoomDataServiceMysqlImpl() throws RemoteException{
		super();
	}
	
	
	@Override
	public ResultMessage add(RoomPO room) throws RemoteException{
		if(room == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		params.add(room.getHotel_id());
		params.add(room.getRoom_number());
		params.add(room.getRoom_type());
		params.add(room.getRoom_price());
		params.add(room.getRoom_condition().toString());
		
		String sql = sqlManager.appendSQL("INSERT INTO room VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql,params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}


	@Override
	public ArrayList<RoomPO> findRoom(String hotel_id, String room_type) throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<RoomPO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM room WHERE hotel_id=? AND type=?";
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql,new Object[]{hotel_id,room_type});
		
		for(Map<String, Object> map : mapList){
			list.add(getRoomPO(map));
		}
		sqlManager.releaseAll();
		return list;
	}


	@Override
	public ArrayList<RoomPO> getAllRoom(String hotel_id) throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<RoomPO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM room WHERE hotel_id=?";
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{hotel_id});
		
		for(Map<String, Object> map : mapList){
			list.add(getRoomPO(map));
		}
		return list;
	}


	@Override
	public ResultMessage addRoomCondition(RoomConditionDatePO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<>();
		
		params.add(po.getHotel_id());
		params.add(po.getRoomDate());
		params.add(po.getRoomNumber());
		params.add(po.getRoomCondition().toString());
		
		String sql = sqlManager.appendSQL("INSERT INTO roomCondition VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}


	@Override
	public ResultMessage modifyRoomCondition(RoomConditionDatePO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<>();

		params.add(po.getRoomCondition().toString());
		params.add(po.getHotel_id());
		params.add(po.getRoomDate());
		params.add(po.getRoomNumber());
		
		String sql = "UPDATE roomCondition SET roomcondition=? WHERE hotel_id=? AND roomdate=? AND room_id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		return ResultMessage.SUCCESS;
	}


	@Override
	public ResultMessage deleteRoomCondition(RoomConditionDatePO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<>();
		
		params.add(po.getHotel_id());
		params.add(po.getRoomDate());
		params.add(po.getRoomNumber());
		
		String sql = "DELETE FROM roomCondition WHERE hotel_id=? AND roomdate=? AND room_id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}


	@Override
	public ArrayList<RoomConditionDatePO> getAllByDate(String date) throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<RoomConditionDatePO> list = new ArrayList<>();
		
		String sql= "SELECT * FROM roomCondition WHERE roomdate=?";
		
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{date});
		
		for(Map<String, Object> map : mapList){
			list.add(getRoomConditionDatePO(map));
		}
		sqlManager.releaseAll();
		return list;
	}


	@Override
	public ArrayList<RoomConditionDatePO> getRoomConditionPO(String hotel_id, String room_number)throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<RoomConditionDatePO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM roomCondition WHERE hotel_id=? AND room_id=?";
		
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{hotel_id,room_number});
		
		for(Map<String,Object> map : mapList){
			list.add(getRoomConditionDatePO(map));
		}
		sqlManager.releaseAll();
		return list;
	}
	
	
	@Override 
	public ResultMessage modify(RoomPO room) throws RemoteException {
		if(room == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<>();	
		params.add(room.getRoom_price());
		params.add(room.getRoom_condition().toString());
		params.add(room.getHotel_id());
		params.add(room.getRoom_number());
		
		String sql = "UPDATE room SET price=?, currentCondition=? WHERE hotel_id=? AND room_id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}
	

	@Override
	public ArrayList<RoomPO> getAllRooms() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<RoomPO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM room";
		
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String,Object> map : mapList){
			list.add(getRoomPO(map));
		}
		return list;
	}
	
	private RoomPO getRoomPO(Map<String,Object> map){
		RoomPO po = new RoomPO();
		
		po.setHotel_id(map.get("hotel_id").toString());
		po.setRoom_number(map.get("room_id").toString());
		po.setRoom_type(map.get("type").toString());
		po.setRoom_price(Integer.parseInt(map.get("price").toString()));
		
		String roomCondition = map.get("currentCondition").toString();
		switch(roomCondition){
		case"UNRESERVED":
			po.setRoom_condition(RoomCondition.UNRESERVED);
			break;
		case"RESERVED":
			po.setRoom_condition(RoomCondition.RESERVED);
			break;
		case"CHECKIN":
			po.setRoom_condition(RoomCondition.CHECKIN);
			break;
		}
		
		return po;
	}
	
	private RoomConditionDatePO getRoomConditionDatePO(Map<String, Object> map){
		RoomConditionDatePO po = new RoomConditionDatePO();
		
		po.setHotel_id(map.get("hotel_id").toString());
		po.setRoomDate(map.get("roomdate").toString());
		po.setRoomNumber(map.get("room_id").toString());
		
		String roomCondition = map.get("roomcondition").toString();
		switch(roomCondition){
		case"UNRESERVED":
			po.setRoomCondition(RoomCondition.UNRESERVED);
			break;
		case"RESERVED":
			po.setRoomCondition(RoomCondition.RESERVED);
			break;
		case"CHECKIN":
			po.setRoomCondition(RoomCondition.CHECKIN);
			break;
		}
		
		return po;
	}

}
