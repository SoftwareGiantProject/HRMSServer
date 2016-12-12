package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.time.chrono.MinguoEra;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.userdataservice.ClientDataService;
import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;

public class ClientDataServiceImplTest {
	
	private ClientDataService clientDataService;
	
	@Before
	public void init(){
		try {
			clientDataService = DatabaseFactoryMysqlImpl.getInstance().getClientData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	@Test  add方法已测试成功
	public void testAdd(){
		ClientPO po = new ClientPO();
		
		po.setUserId("151230001");
		po.setMemberId("");
		po.setUserName("Tom");
		po.setPassword("123456");
		po.setCredit(500);
		po.setContact("");
		po.setBirthday("");
		po.setType(MemberType.NONE);
		
		try {
			clientDataService.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testFindClient(){
		String id = "151250061";
		
		ClientPO po = new ClientPO();
		
		try {
			po = clientDataService.findClient(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals("C00002",po.getMemberId());
		assertEquals(MemberType.CORPORATEMEMBER,po.getType());
	}
	
	/**
	@Test modify方法已测试
	public void testModify(){
		ClientPO po = new ClientPO();
		
		po.setUserId("151250061");
		po.setMemberId("C00002");
		po.setUserName("黄岩");
		po.setPassword("huangyan529");
		po.setCredit(900);
		po.setContact("loohaze529@gmail.com");
		po.setBirthday("1997-5-29");
		po.setType(MemberType.CORPORATEMEMBER);
		
		try {
			clientDataService.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test 获得列表方法测试成功
	public void testGetAllClient(){
		ArrayList<ClientPO> list = new ArrayList<>();
		
		try {
			list = clientDataService.getAllClient();
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		
		assertEquals("C00001", list.get(2).getMemberId());
		assertEquals(MemberType.NONE, list.get(1).getType());
	}
	*/
	
	/**
	@Test 注册普通会员已测试成功
	public void testRegistComMember(){
		CommonMemberPO po = new CommonMemberPO();
		
		po.setCommonMember_number("C00005");
		po.setCommonMember_level(1);
		po.setCommonMember_Birthday("");
		po.setMember_type(MemberType.COMMONMEMBER);
		
		try {
			clientDataService.registComMember(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	@Test 注册企业会员已测试成功
	public void testRegistCorMember(){
		CorporateMemberPO po = new CorporateMemberPO();
		
		po.setCorporateMember_number("C00006");
		po.setCorporateMember_level(1);
		po.setCorporateMember_Birthday("");
		po.setMemberType(MemberType.CORPORATEMEMBER);
		po.setCorporate("");
		
		try {
			clientDataService.registCorMember(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testCheckExist() throws RemoteException{
		String id1 = "151250061";
		String id2 = "122131221";
		
		assertEquals(ResultMessage.SUCCESS, clientDataService.checkExist(id1));
		assertEquals(ResultMessage.FAIL, clientDataService.checkExist(id2));
	}
}
