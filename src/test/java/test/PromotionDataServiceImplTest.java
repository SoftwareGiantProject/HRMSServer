package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.promotiondataservice.PromotionDataService;
import po.MemberPromotionPO;
import po.PromotionPO;

public class PromotionDataServiceImplTest {
	
	private PromotionDataService  promotionDataService;
	
	@Before
	public void init() throws RemoteException{
		promotionDataService = DatabaseFactoryMysqlImpl.getInstance().getPromotionData();
	}
	
	/**
	 * add方法已通过测试
	@Test
	public void testAddPromotion(){
		PromotionPO po = new PromotionPO();
		
		po.setPromotionName("双十一促销策略");
		po.setPromotionObject("所有客户");
		po.setTime("2016-11-7 to 2016-11-15");
		po.setCount(8);
		po.setSeller("hotel");
		
		try {
			promotionDataService.addPromotion(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * modify方法已通过测试
	@Test
	public void testModifyPromotion(){
		PromotionPO po = new PromotionPO();
		
		po.setPromotionName("双十一促销策略");
		po.setPromotionObject("所有客户");
		po.setTime("2016-11-7 to 2016-11-15");
		po.setCount(7.5);
		po.setSeller("hotel");
		
		try {
			promotionDataService.modifyPromotion(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * del方法已通过测试
	@Test
	public void testDelPromotion(){
		PromotionPO po = new PromotionPO();
		
		po.setPromotionName("双十一促销策略");
		po.setPromotionObject("所有客户");
		po.setTime("2016-11-7 to 2016-11-15");
		po.setCount(7.5);
		po.setSeller("hotel");
		
		try {
			promotionDataService.delPromotion(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * add会员促销策略测试成功
	@Test
	public void testAddMemberPromotion(){
		MemberPromotionPO po = new MemberPromotionPO();
		
		po.setPromotionName("会员特定商圈专属折扣");
		po.setTime("2016-1-1 to 2020-1-1");
		po.setCount(9.5);
		po.setArea("栖霞区 ，秦淮区，六合区");
		
		try {
			promotionDataService.addMemberPromotion(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Test
	public void testFindPromotion(){
		String name = "双十一促销策略";
		
		PromotionPO po = new PromotionPO();
		try {
			po = promotionDataService.findPromotion(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(po.getCount()+po.getSeller(),(double)8+"hotel");
	}
	
	@Test
	public void testFindMemberPromotion(){
		String name = "会员特定商圈专属折扣";
		
		MemberPromotionPO po = new MemberPromotionPO();
		
		try{
			po = promotionDataService.findMemberPromotion(name);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		assertEquals(po.getCount()+po.getArea(), (double)9.5 + "栖霞区，秦淮区，六合区");
	}
	
	@Test
	public void testGetAllPromotion(){
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		
		try {
			list = promotionDataService.getAllPromotion();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		assertEquals(list.get(1).getPromotionName(), "三间及以上预定特惠");
		assertEquals(list.get(0).getTime(), "2016-11-7 to 2016-11-15");
	}
}
