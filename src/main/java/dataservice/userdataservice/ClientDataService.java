package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.ResultMessage;

public interface ClientDataService extends Remote{

	public ResultMessage add(ClientPO po)throws RemoteException;
	public ClientPO findClient(String id)throws RemoteException;
	public ArrayList<ClientPO> getAllClient()throws RemoteException;
	
	public ResultMessage registComMember(CommonMemberPO po)throws RemoteException;
	public ResultMessage registCorMember(CorporateMemberPO po)throws RemoteException;
	public ResultMessage modify(ClientPO po)throws RemoteException;
}
