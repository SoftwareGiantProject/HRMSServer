package data.hoteldata;

import java.util.List;

import data.sqlmanager.SqlManager;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelPO;
import po.RoomPO;
import util.ResultMessage;

/**
 * Hotel数据层的具体实现
 * @author looh
 *
 */
public class HotelDataServiceMysqlImpl implements HotelDataService{
	
	SqlManager sqlManager = SqlManager.getSqlManager();
	
	
	@Override
	public RoomPO seekHotel(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage evaluateHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPO> viewHistoryHotel() {
		// TODO Auto-generated method stub
		return null;
	}

}
