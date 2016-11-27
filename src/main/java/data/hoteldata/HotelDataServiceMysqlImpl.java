package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public HotelPO seekHotel(String hotel_name) throws RemoteException {
		sqlManager.getConnection();
		
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "SELECT * FROM hotel WHERE name=?";
		map = sqlManager.querySimple(sql, new Object[]{hotel_name});
		
		HotelPO po = getHotelPO(map);
		
		sqlManager.releaseAll();
		return po;
	}

	@Override
	public ResultMessage addHotel(HotelPO po) throws RemoteException{
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params =  new ArrayList<Object>();
		
		params.add(po.getHotelId());
		params.add(po.getHotelName());
		params.add(po.getHotelAddress());
		params.add(po.getHotelArea());
		params.add(po.getHotelIntro());
		params.add(po.getHotelServe());
		params.add(po.getHotelRoom());
		
		String sql  = sqlManager.appendSQL("INSERT INTO hotel VALUES", params.size());
 		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) throws RemoteException {
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		
		/*
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getHotelName());
		params.add(po.getHotelAddress());
		params.add(po.getHotelArea());
		params.add(po.getHotelIntro());
		params.add(po.getHotelServe());
		params.add(po.getHotelRoom());
		*/
		
		String sql = "UPDATE hotel SET" + "name=" + po.getHotelName() + "," +
				      "address=" + po.getHotelAddress() + "," +
				      "area=" + po.getHotelAddress() + "," +
				      "intro=" + po.getHotelIntro() + "," +
				      "serve=" + po.getHotelServe() + "," +
				      "room=" + po.getHotelRoom() + 
				      "WHERE" + "id=" + po.getHotelId();
		
		sqlManager.executeUpdate(sql);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage evaluateHotel(HotelEvaluationPO po) throws RemoteException{
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getOrder_id());
		params.add(po.getUser_id());
		params.add(po.getDate());
		params.add(po.getData());
		params.add(po.getLevel());
		
		String sql = sqlManager.appendSQL("INSERT INTO hotelEvaluation VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<HotelPO> viewHistoryHotel() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	private HotelPO getHotelPO(Map<String,Object> map){
		HotelPO po = new HotelPO();
		po.setHotelId(map.get("id").toString());
		po.setHotelName(map.get("name").toString());
		po.setHotelAddress(map.get("address").toString());
		po.setHotelArea(map.get("area").toString());
		po.setHotelIntro(map.get("intro").toString());
		po.setHotelServe(map.get("serve").toString());
		po.setHotelRoom(map.get("room").toString());
		
		return po;
	}
	
	
}
