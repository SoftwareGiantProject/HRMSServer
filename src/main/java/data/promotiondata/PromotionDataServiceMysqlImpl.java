package data.promotiondata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;
import util.ResultMessage;

public class PromotionDataServiceMysqlImpl implements PromotionDataService{

	private SqlManager sqlManager = SqlManager.getSqlManager();
	
	@Override
	public PromotionPO findPromotion(String name) {
		sqlManager.getConnection();
		
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "SELECT * FROM promotion WHERE name=?";
		map = sqlManager.querySimple(sql, new Object[]{name});
		
		PromotionPO po = getPromotionPO(map);
		
		sqlManager.releaseAll();
		return po;
	}

	@Override
	public ResultMessage addPromotion(PromotionPO po) {
		if(po == null)
			return ResultMessage.FAIL;
		
		sqlManager.getConnection();
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getPromotionName());
		params.add(po.getPromotionObject());
		params.add(po.getTime());
		params.add(po.getCount());
		
		String sql = sqlManager.appendSQL("INSERT INTO promotion VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionPO> getAllPromotion() {
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
	public ResultMessage addMemberPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private PromotionPO getPromotionPO(Map<String, Object> map){
		PromotionPO po = new PromotionPO();
		
		po.setPromotionName(map.get("name").toString());
		po.setPromotionObject(map.get("object").toString());
		po.setTime(map.get("time").toString());
		po.setCount(Double.parseDouble(map.get("count").toString()));
		
		return po;
	}
}
