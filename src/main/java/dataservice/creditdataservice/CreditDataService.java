package dataservice.creditdataservice;

import po.*;
import util.*;

public interface CreditDataService {

	public CreditPO find(String user_id);
	public ResultMessage modify(CreditPO po);
	public ResultMessage trade(CreditPO po);
	
}
