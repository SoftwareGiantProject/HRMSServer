package data.memberdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.memberdataservice.MemberDataService;
import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;

public class MemberDataServiceMysqlImpl extends UnicastRemoteObject  implements MemberDataService{

	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public MemberDataServiceMysqlImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<CommonMemberPO> getComMember() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<CommonMemberPO> list = new ArrayList<CommonMemberPO>();
		
		String sql = "SELECT * FROM member WHERE type='COM'";
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String,Object> map : mapList){
			list.add(getCommomMemberPO(map));
		}	
		
		sqlManager.releaseAll();
		return list;
	}

	@Override
	public ArrayList<CorporateMemberPO> getCorMember() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<CorporateMemberPO> list = new ArrayList<CorporateMemberPO>();
		
		String sql = "SELECT * FROM member WHERE type='COR'";
		List<Map<String, Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String,Object> map : mapList){
			list.add(getCorporateMemberPO(map));
		}
		
		sqlManager.releaseAll();
		return list;
	}

	@Override
	public ResultMessage addComMember(CommonMemberPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getCommonMember_number());
		params.add(po.getCommonMember_level());
		params.add(po.getCommonMember_Birthday());
		params.add("COM");
		params.add("");
		
		String sql = sqlManager.appendSQL("INSERT INTO member VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addCorMember(CorporateMemberPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getCorporateMember_number());
		params.add(po.getCorporateMember_level());
		params.add(po.getCorporateMember_Birthday());
		params.add("COR");
		params.add(po.getCorporate());
		
		String sql = sqlManager.appendSQL("INSERT INTO member VALUES",params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseConnection();
		return ResultMessage.SUCCESS;
	}

	private CommonMemberPO getCommomMemberPO(Map<String, Object> map){
		CommonMemberPO po = new CommonMemberPO();
		
		po.setCommonMember_number(map.get("member_id").toString());
		po.setCommonMember_Birthday(map.get("birthday").toString());
		po.setCommonMember_level(Integer.parseInt(map.get("level").toString()));
		po.setMember_type(MemberType.COMMONMEMBER);
		
		return po;
	}

	private CorporateMemberPO getCorporateMemberPO(Map<String, Object> map){
		CorporateMemberPO po = new CorporateMemberPO();
		
		po.setCorporateMember_number(map.get("member_id").toString());
		po.setCorporateMember_Birthday(map.get("birthday").toString());
		po.setCorporateMember_level(Integer.parseInt(map.get("level").toString()));
		po.setCorporate(map.get("corporate").toString());
		po.setMemberType(MemberType.CORPORATEMEMBER);
		
		return po;
	}
}
