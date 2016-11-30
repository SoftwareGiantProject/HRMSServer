package dataservice.roomdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;


public interface RoomDataService extends Remote{

	public ArrayList<RoomPO> findRoom(String hotel_id,String room_type)throws RemoteException;
	public ResultMessage add(RoomPO room) throws RemoteException;
	
	public RoomPO checkOut(RoomPO room_info) throws RemoteException;
	public RoomPO reserve(RoomPO room_info)throws RemoteException;
	
}
