package dataservice.roomdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;


public interface RoomDataService extends Remote{
	
	public ArrayList<RoomConditionDatePO> getRoomConditionByOrder(String order_id)throws RemoteException;
	
	public ArrayList<RoomPO> findRoom(String hotel_id,String room_type)throws RemoteException;

	public ResultMessage add(RoomPO room) throws RemoteException;

	public ResultMessage modify(RoomPO room) throws RemoteException;

	public ArrayList<RoomPO> getAllRoom(String hotel_id)throws RemoteException;

	public ArrayList<RoomConditionDatePO> getAllRoomCondition()throws RemoteException;

	public ResultMessage addRoomCondition(RoomConditionDatePO po)throws RemoteException;

	public ResultMessage modifyRoomCondition(RoomConditionDatePO po) throws RemoteException;

	public ResultMessage deleteRoomCondition(RoomConditionDatePO po) throws RemoteException;

	public ArrayList<RoomConditionDatePO> getAllByDate(String date) throws RemoteException;
	
	public ArrayList<RoomConditionDatePO> getRoomConditionPO(String hotel_id, String room_number) throws RemoteException;

	public ArrayList<RoomConditionDatePO> getRoomConditionPOByHotelId(String hotel_id)throws RemoteException;
	
	public ArrayList<RoomPO> getAllRooms()throws RemoteException;
	
}
