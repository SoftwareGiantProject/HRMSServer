package dataservice.roomdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.*;
import util.*;


public interface RoomDataService extends Remote{

	public ResultMessage add(RoomPO room) throws RemoteException;
	
	public RoomPO checkOut(RoomPO room_info) throws RemoteException;
	public RoomPO reserve(RoomPO room_info)throws RemoteException;
	
}
