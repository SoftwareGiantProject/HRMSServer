package dataservice.roomdataservice;

import java.rmi.RemoteException;

import po.*;
import util.*;

public interface RoomDataService {

	public ResultMessage add(RoomPO room) throws RemoteException;
    public ResultMessage modify(RoomPO room);
    public RoomPO find(RoomPO room);
    
}
