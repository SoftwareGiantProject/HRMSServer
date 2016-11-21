package dataservice.hoteldataservice;

import java.util.List;

import po.*;
import util.*;


public interface HotelDataService {


	public RoomPO seekHotel(String hotel_id);
	public List<HotelPO> viewHistoryHotel();
	
	public ResultMessage addHotel(HotelPO po);
	public ResultMessage modifyHotel(HotelPO po);
	public ResultMessage evaluateHotel(HotelPO po);
}
