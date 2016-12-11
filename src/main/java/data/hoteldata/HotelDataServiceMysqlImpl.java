package data.hoteldata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.mysql.fabric.xmlrpc.base.Array;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import data.sqlmanager.SqlManager;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelEvaluationPO;
import po.HotelPO;
import po.OrderPO;
import po.RecordOrderPO;
import util.ResultMessage;

/**
 * Hotel数据层的具体实现
 * @author looh
 *
 */
public class HotelDataServiceMysqlImpl extends UnicastRemoteObject  implements HotelDataService{
	
	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public HotelDataServiceMysqlImpl() throws RemoteException {
		super();
	}
	
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
		params.add(po.getHotelLevel());
		params.add(po.getHotelScore());
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
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getHotelName());
		params.add(po.getHotelLevel());
		params.add(po.getHotelScore());
		params.add(po.getHotelAddress());
		params.add(po.getHotelArea());
		params.add(po.getHotelIntro());
		params.add(po.getHotelServe());
		params.add(po.getHotelRoom());
		params.add(po.getHotelId());
		
		String sql = "UPDATE hotel SET name=? , level=? , score=? , address=? , area=? , intro=? , serve= ? , room=? WHERE id=?";

		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage evaluateHotel(HotelEvaluationPO po) throws RemoteException{
		if(po == null)
			return ResultMessage.FAIL;
		
		OrderPO orderPO = DatabaseFactoryMysqlImpl.getInstance().getOrderData().findOrder(po.getOrder_id());
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getOrder_id());
		params.add(po.getUser_id());
		params.add(getNameById(orderPO.getHotel_id()));
		params.add(po.getDate());
		params.add(po.getData());
		params.add(po.getLevel());
		
		String sql = sqlManager.appendSQL("INSERT INTO hotelEvaluation VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<HotelPO> getReservedHotel(String user_id) throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		String sql = "SELECT DISTINCT hotel_name FROM recordOrder WHERE user_id=?";
		
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{user_id});
		
		for(Map<String,Object> map : mapList){
			nameList.add(map.get("hotel_name").toString());
		}
		
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		
		for(String s : nameList){
			list.add(seekHotel(s));
		}
		
		return list;
	}

	@Override
	public ArrayList<HotelPO> getHotelByArea(String area) throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		
		String sql = "SELECT * FROM hotel WHERE area=?";
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{area});
		
		for(Map<String ,Object> map : mapList){
			list.add(getHotelPO(map));
		}
		
		sqlManager.releaseAll();
		return list;
	}

	@Override
	public ArrayList<HotelPO> getHotelByLevel(int level) throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		
		String sql = "SELECT * FROM hotel WHERE level=" + "'" + level + "'";
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String ,Object> map : mapList){
			list.add(getHotelPO(map));
		}
		
		sqlManager.releaseAll();
		return list;
	}

	@Override
	public ArrayList<HotelEvaluationPO> getAllHotelEvaluation(String hotel_name) throws RemoteException{
		sqlManager.getConnection();
		
		ArrayList<HotelEvaluationPO> list = new ArrayList<HotelEvaluationPO>();
		
		String sql = "SELECT * FROM hotelevaluation WHERE hotel_name=?";
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{hotel_name});
		
		for(Map<String, Object> map : mapList){
			list.add(getHotelEvaluationPO(map));
		}
		
		return list;
	}

	@Override
	public ArrayList<HotelPO> getAllHotel(String user_id, String hotel_id) throws RemoteException{
		sqlManager.getConnection();
		
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT DISTINCT hotel_name FROM recordOrder WHERE user_id=? AND hotel_id=?";
		
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{user_id,hotel_id});
		
		for(Map<String,Object> map : mapList){
			list.add(map.get("hotel_name").toString());
		}
		
		ArrayList<HotelPO> hotelPOList = new ArrayList<HotelPO>();
		for(String s : list){
			hotelPOList.add(seekHotel(s));
		}
		return hotelPOList;
	}
	
	@Override
	public ArrayList<HotelPO> getAllHotels() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		
		String sql = "SELECT * FROM hotel";
		
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String, Object> map : mapList){
			list.add(getHotelPO(map));
		}
		
		return list;
	}
	

	@Override
	public ArrayList<String> getAllCity() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<String> list = new ArrayList<>();
		
		String sql = "SELECT * FROM city";
		
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String,Object> map : mapList){
			list.add(map.get("city").toString());
		}
		
		sqlManager.releaseAll();
		return list;
	}

	@Override
	public ArrayList<String> getAllAreaByCity(String city) throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<String> list = new ArrayList<>();
				
		String sql = "SELECT * FROM area WHERE city=?";
		
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{city});
		
		for(Map<String, Object> map : mapList){
			list.add(map.get("area").toString());
		}
		
		sqlManager.releaseAll();
		return list;
	}

	private String getNameById(String hotel_id){
		HotelPO po = new HotelPO();
	
		sqlManager.getConnection();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String sql = "SELECT * FROM hotel WHERE id=?";
		map = sqlManager.querySimple(sql, new Object[]{hotel_id});
		
		po = getHotelPO(map);
		return po.getHotelName();
	}
	
	private RecordOrderPO getRecordOrderPO(Map<String, Object> map){
		RecordOrderPO po = new RecordOrderPO();
		
		po.setHotel_id(map.get("hotel_id").toString());
		po.setHotel_name(map.get("hotel_name").toString());
		po.setOrder_id(map.get("order_id").toString());
		po.setUser_id(map.get("user_id").toString());
		
		return po;
	}
	
	private HotelEvaluationPO getHotelEvaluationPO(Map<String,Object> map){
		HotelEvaluationPO po = new HotelEvaluationPO();
		
		po.setOrder_id(map.get("order_id").toString());
		po.setUser_id(map.get("user_id").toString());
		po.setData(map.get("data").toString());
		po.setDate(map.get("date").toString());
		po.setLevel(Integer.parseInt(map.get("level").toString()));
		
		return po;
	}
	private HotelPO getHotelPO(Map<String,Object> map){
		HotelPO po = new HotelPO();
		po.setHotelId(map.get("id").toString());
		po.setHotelName(map.get("name").toString());
		po.setHotelLevel(Integer.parseInt(map.get("level").toString()));
		po.setHotelScore(Double.parseDouble(map.get("score").toString()));
		po.setHotelAddress(map.get("address").toString());
		po.setHotelArea(map.get("area").toString());
		po.setHotelIntro(map.get("intro").toString());
		po.setHotelServe(map.get("serve").toString());
		po.setHotelRoom(map.get("room").toString());
		
		return po;
	}
}
