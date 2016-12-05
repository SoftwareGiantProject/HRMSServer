package data.roomdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mysql.fabric.xmlrpc.base.Array;

import data.sqlmanager.SqlManager;
import dataservice.roomdataservice.RoomDataService;
import po.RoomConditionDatePO;
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
	public ArrayList<RoomPO> findRoom(String hotel_id, String room_type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<RoomPO> getAllRoom(String hotel_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage addRoomCondition(RoomConditionDatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage modifyRoomCondition(RoomConditionDatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage deleteRoomCondition(RoomConditionDatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<RoomConditionDatePO> getAllByDate(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
