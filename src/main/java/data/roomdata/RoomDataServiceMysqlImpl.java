package data.roomdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mysql.fabric.xmlrpc.base.Array;

import data.sqlmanager.SqlManager;
import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import util.ResultMessage;
import java.util.ArrayList;
import java.util.List;

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
		params.add(room.getRoom_type());
		params.add(room.getRoom_number());
		params.add(room.getRoom_price());
		params.add(room.getRoom_condition());
		
		String sql = sqlManager.appendSQL("INSERT INTO room VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql,params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}


	@Override
	public RoomPO checkOut(RoomPO room_info) throws RemoteException{
		if(room_info == null){
			return null;
		}
		
		sqlManager.getConnection();
		
		List<Object> params= new ArrayList<Object>();
		
		params.add("unreserved");
		params.add(room_info.getHotel_id());
		params.add(room_info.getRoom_number());
		
		String sql = "UPDATE room SET condition=? WHERE hotel_id=?, room_id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return null;
	}


	@Override
	public RoomPO reserve(RoomPO room_info) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<RoomPO> findRoom(String hotel_id, String room_type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
