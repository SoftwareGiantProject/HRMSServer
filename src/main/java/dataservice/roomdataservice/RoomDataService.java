package dataservice.roomdataservice;

import java.rmi.RemoteException;

import po.*;
import util.*;


public interface RoomDataService {

	public ResultMessage add(RoomPO room) throws RemoteException;
	
	public RoomPO checkOut(RoomPO room_info);
	public RoomPO reserve(RoomPO room_info);
	
}
