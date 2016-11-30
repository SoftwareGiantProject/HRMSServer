package test;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.memberdataservice.MemberDataService;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;

public class MemberDataServiceImplTest {

	private MemberDataService memberDataService;
	
	@Before
	public void init() throws RemoteException{
		memberDataService = DatabaseFactoryMysqlImpl.getInstance().getMemberData();
	}
	
	@Test
	public void testGetComMember(){
		ArrayList<CommonMemberPO> list = new ArrayList<CommonMemberPO>();
		
		try {
			list = memberDataService.getComMember();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		CommonMemberPO po = list.get(0);
		assertEquals("1997-10-3",po.getCommonMember_Birthday());
	}
	
	@Test
	public void testGetCorMember(){
		ArrayList<CorporateMemberPO> list = new ArrayList<CorporateMemberPO>();
		
		try {
			list = memberDataService.getCorMember();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		CorporateMemberPO po = list.get(0);
		assertEquals("Tencent",po.getCorporate());
	}
	
	/**
	 * add方法已测试成功
	@Test
	public void testAddComMember(){
		CommonMemberPO po = new CommonMemberPO();
		
		po.setCommonMember_number("C00003");
		po.setCommonMember_level(0);
		po.setCommonMember_Birthday("1997-4-23");
		po.setMember_type(MemberType.COMMONMEMBER);
		
		try {
			memberDataService.addComMember(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddCorMember(){
		CorporateMemberPO po = new CorporateMemberPO();
		
		po.setCorporateMember_number("C00004");
		po.setCorporateMember_level(1);
		po.setCorporateMember_Birthday("1997-3-12");
		po.setMemberType(MemberType.CORPORATEMEMBER);
		po.setCorporate("Baidu");
		
		try {
			memberDataService.addCorMember(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
}
