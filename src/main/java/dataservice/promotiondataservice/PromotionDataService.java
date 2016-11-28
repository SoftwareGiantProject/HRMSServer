package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import util.*;

public interface PromotionDataService extends Remote{

	public PromotionPO findPromotion(String name) throws RemoteException;
	public MemberPromotionPO findMemberPromotion(String name) throws RemoteException;
	public ArrayList<PromotionPO> getAllPromotion() throws RemoteException;
	
	public ResultMessage addMemberPromotion(MemberPromotionPO po) throws RemoteException;
	public ResultMessage addPromotion(PromotionPO po) throws RemoteException;
	public ResultMessage modifyPromotion(PromotionPO po) throws RemoteException;
	public ResultMessage delPromotion(PromotionPO po) throws RemoteException;
}
