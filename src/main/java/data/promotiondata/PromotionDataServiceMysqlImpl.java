package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.promotiondataservice.PromotionDataService;
import po.MemberPromotionPO;
import po.PromotionPO;
import util.ResultMessage;

public class PromotionDataServiceMysqlImpl implements PromotionDataService{

	private SqlManager sqlManager = SqlManager.getSqlManager();
	
	@Override
	public MemberPromotionPO findMemberPromotion(String name) throws RemoteException{
		sqlManager.getConnection();
		
		Map<String , Object> map = new HashMap<String , Object>();
		String sql = "SELECT * FROM memberPromotion WHERE name=?";
		map = sqlManager.querySimple(sql, new Object[]{name});
		
		MemberPromotionPO po = getMemberPromotionPO(map);
		
		sqlManager.releaseAll();
		return po;
	}
	
	@Override
	public PromotionPO findPromotion(String name)  throws RemoteException{
		sqlManager.getConnection();
		
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "SELECT * FROM promotion WHERE name=?";
		map = sqlManager.querySimple(sql, new Object[]{name});
		
		PromotionPO po = getPromotionPO(map);
		
		sqlManager.releaseAll();
		return po;
	}

	@Override
	public ResultMessage addPromotion(PromotionPO po) throws RemoteException {
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getPromotionName());
		params.add(po.getPromotionObject());
		params.add(po.getTime());
		params.add(po.getCount());
		params.add(po.getSeller());
		
		String sql = sqlManager.appendSQL("INSERT INTO promotion VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyPromotion(PromotionPO po) throws RemoteException {
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getPromotionObject());
		params.add(po.getTime());
		params.add(po.getCount());
		params.add(po.getSeller());
		params.add(po.getPromotionName());
		
		String sql = "UPDATE promotion SET object=? , time=? , count=? ,seller=? WHERE name=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delPromotion(PromotionPO po) throws RemoteException {
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getPromotionName());
		params.add(po.getSeller());
		
		String sql = "DELETE FROM promotion WHERE name=? AND seller=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PromotionPO> getAllPromotion()  throws RemoteException{
		sqlManager.getConnection();
		
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		
		String sql = "SELECT * FROM promotion ORDER BY name DESC";
		
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		for(Map<String, Object> map : mapList){
			list.add(getPromotionPO(map));
		}
		
		sqlManager.releaseAll();
		return list;
	}

	@Override
	public ResultMessage addMemberPromotion(MemberPromotionPO po) throws RemoteException {
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		List<Object> params  = new ArrayList<Object>();
		
		params.add(po.getPromotionName());
		params.add(po.getPromotionObject());
		params.add(po.getTime());
		params.add(po.getCount());
		params.add(po.getArea());
		
		String sql = sqlManager.appendSQL("INSERT INTO memberPromotion VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}

	private MemberPromotionPO getMemberPromotionPO(Map<String, Object> map){
		MemberPromotionPO po = new MemberPromotionPO();
		
		po.setPromotionName(map.get("name").toString());
		po.setTime(map.get("time").toString());
		po.setCount(Double.parseDouble(map.get("count").toString()));
		po.setArea(map.get("area").toString());
		
		return po;
	}
	
	private PromotionPO getPromotionPO(Map<String, Object> map){
		PromotionPO po = new PromotionPO();
		
		po.setPromotionName(map.get("name").toString());
		po.setPromotionObject(map.get("object").toString());
		po.setTime(map.get("time").toString());
		po.setCount(Double.parseDouble(map.get("count").toString()));
		po.setSeller(map.get("seller").toString());
		
		return po;
	}
}
