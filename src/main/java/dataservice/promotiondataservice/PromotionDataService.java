package dataservice.promotiondataservice;

import java.util.ArrayList;

import po.*;
import util.*;

public interface PromotionDataService {

	public PromotionPO findPromotion(String name);
	public MemberPromotionPO findMemberPromotion(String name);
	public ArrayList<PromotionPO> getAllPromotion();
	
	public ResultMessage addMemberPromotion(MemberPromotionPO po);
	public ResultMessage addPromotion(PromotionPO po);
	public ResultMessage modifyPromotion(PromotionPO po);
	public ResultMessage delPromotion(PromotionPO po);
}
