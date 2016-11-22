package data.hoteldata;

import java.rmi.RemoteException;
import java.util.List;

import data.sqlmanager.SqlManager;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelEvaluationPO;
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
	public RoomPO seekHotel(String hotel_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage evaluateHotel(HotelEvaluationPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPO> viewHistoryHotel() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
