package dataservice.memberdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;

public interface MemberDataService extends Remote{

	public ArrayList<CommonMemberPO> getComMember() throws RemoteException;
	public ArrayList<CorporateMemberPO> getCorMember() throws RemoteException;

	public ResultMessage addComMember(CommonMemberPO po) throws RemoteException;
	public ResultMessage addCorMember(CorporateMemberPO po) throws RemoteException;
	
}
