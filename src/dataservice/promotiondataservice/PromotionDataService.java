package dataservice.promotiondataservice;

import po.*;
import util.*;

public interface PromotionDataService {

	public PromotionPO findPromotion(String id);
	
	public ResultMessage addPromotion(PromotionPO po);
	public ResultMessage modifyPromotion(PromotionPO po);
	public ResultMessage delPromotion(PromotionPO po);
}
