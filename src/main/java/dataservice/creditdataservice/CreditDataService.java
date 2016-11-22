package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;

public interface CreditDataService {

	public CreditPO find(String user_id) throws RemoteException;
	public ResultMessage modify(CreditPO po) throws RemoteException;
	
	public ArrayList<CreditPO> getHistoryCredit(String user_id);
}
