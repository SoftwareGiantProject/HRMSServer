package data.userdata;

import java.util.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import data.memberdata.MemberDataServiceMysqlImpl;
import data.sqlmanager.SqlManager;
import dataservice.datafactory.DataFactory;
import dataservice.memberdataservice.MemberDataService;
import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;

public class ClientDataServiceMysqlImpl extends UnicastRemoteObject  implements ClientDataService{

	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public ClientDataServiceMysqlImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage add(ClientPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<Object>();
		
		params.add(po.getUserId());
		params.add(po.getMemberId());
		params.add(po.getUserName());
		params.add(po.getPassword());
		params.add(po.getCredit());
		params.add(po.getContact());
		params.add(po.getBirthday());
		switch(po.getType()){
		case COMMONMEMBER :
			params.add("COM");
			break;
		case CORPORATEMEMBER :
			params.add("COR");
			break;
		case NONE :
			params.add("NONE");
			break;
		}
		
		String sql = sqlManager.appendSQL("INSERT INTO client VALUES", params.size());
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ClientPO findClient(String id) throws RemoteException {
		sqlManager.getConnection();
		
		Map<String, Object> map = new HashMap<>();
		String sql = "SELECT * FROM client WHERE id=?";
		map = sqlManager.querySimple(sql, new Object[]{id});
		
		ClientPO po = getClientPO(map);
		return po;
	}

	@Override
	public ResultMessage modify(ClientPO po) throws RemoteException {
		if(po == null){
			return ResultMessage.FAIL;
		}
		
		sqlManager.getConnection();
		List<Object> params = new ArrayList<>();
		
		params.add(po.getMemberId());
		params.add(po.getUserName());
		params.add(po.getPassword());
		params.add(po.getCredit());
		params.add(po.getContact());
		params.add(po.getBirthday());
		switch(po.getType()){
		case COMMONMEMBER :
			params.add("COM");
			break;
		case CORPORATEMEMBER :
			params.add("COR");
			break;
		case NONE :
			params.add("NONE");
			break;
		}
		params.add(po.getUserId());
		
		String sql = "UPDATE client SET member_id=?, name=?, password=?, credit=?, contact=?, birthday=?, membertype=? WHERE id=?";
		
		sqlManager.executeUpdateByList(sql, params);
		sqlManager.releaseAll();
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ClientPO> getAllClient() throws RemoteException {
		sqlManager.getConnection();
		
		ArrayList<ClientPO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM client";
		List<Map<String,Object>> mapList = sqlManager.queryMulti(sql, new Object[]{});
		
		for(Map<String,Object> map : mapList){
			list.add(getClientPO(map));
		}
		
		sqlManager.releaseAll();
 		return list;
	}

	@Override
	public ResultMessage registComMember(String user_id,CommonMemberPO po) throws RemoteException {
		MemberDataService memberDataService = DatabaseFactoryMysqlImpl.getInstance().getMemberData();;
		
		ClientPO tempPO = findClient(user_id);
		if(!tempPO.getType().equals(MemberType.NONE)){
			return ResultMessage.FAIL;
		}
		else{
			tempPO.setType(MemberType.COMMONMEMBER);
			tempPO.setMemberId(po.getCommonMember_number());

			modify(tempPO);
			return memberDataService.addComMember(po);
		}
	}

	@Override
	public ResultMessage registCorMember(String user_id,CorporateMemberPO po) throws RemoteException {
		MemberDataService memberDataService = DatabaseFactoryMysqlImpl.getInstance().getMemberData();
		
		ClientPO tempPO = findClient(user_id);
		if(tempPO.getType().equals(MemberType.CORPORATEMEMBER)){
			return ResultMessage.FAIL;
		}
		else{
			tempPO.setType(MemberType.CORPORATEMEMBER);
			tempPO.setMemberId(po.getCorporateMember_number());
		
			modify(tempPO);
			return memberDataService.addCorMember(po);
		}
	}
	

	@Override
	public ResultMessage checkExist(String id) throws RemoteException {
		sqlManager.getConnection();
		
		String sql = "SELECT * FROM client WHERE id=?";
		
		Map<String,Object> map = sqlManager.querySimple(sql, new Object[]{id});
		if(map.isEmpty()){
			return ResultMessage.FAIL;
		}
		else
			return ResultMessage.SUCCESS;
	}
	
	private ClientPO getClientPO(Map<String, Object> map){
		
		ClientPO po = new ClientPO();
		po.setUserId(map.get("id").toString());
		po.setUserName(map.get("name").toString());
		po.setMemberId(map.get("member_id").toString());
		po.setPassword(map.get("password").toString());
		po.setCredit(Integer.parseInt(map.get("credit").toString()));
		po.setContact(map.get("contact").toString());
		po.setBirthday(map.get("birthday").toString());
		
		String membertype = map.get("membertype").toString();
		switch(membertype){
		case"NONE":
			po.setType(MemberType.NONE);
			break;
		
		case"COM":
			po.setType(MemberType.COMMONMEMBER);
			break;
			
		case"COR":
			po.setType(MemberType.CORPORATEMEMBER);
			break;
		}
		
		return po;
	}

}
