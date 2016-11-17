package dataservice.roomdataservice;

import po.*;
import util.*;

public interface RoomDataService {

	public ResultMessage add(RoomPO room);
    public ResultMessage modify(RoomPO room);
    public RoomPO find(RoomPO room);
    
}
