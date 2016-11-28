package dataservice.creditdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;

public interface CreditDataService extends Remote{

	public int getCredit(String user_id) throws RemoteException;
	public CreditPO find(String user_id) throws RemoteException;
	public ResultMessage modify(CreditPO po) throws RemoteException;
	
	public ArrayList<CreditPO> getHistoryCredit(String user_id) throws RemoteException;
}
