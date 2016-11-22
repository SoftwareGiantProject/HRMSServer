package dataservice.creditdataservice;

import java.rmi.RemoteException;

import po.*;
import util.*;

public interface CreditDataService {

	public CreditPO find(String user_id) throws RemoteException;
	public ResultMessage modify(CreditPO po) throws RemoteException;
	
}
