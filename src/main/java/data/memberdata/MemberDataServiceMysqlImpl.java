package data.memberdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.memberdataservice.MemberDataService;
import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;

public class MemberDataServiceMysqlImpl implements MemberDataService{

	@Override
	public ArrayList<CommonMemberPO> getComMember() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CorporateMemberPO> getCorMember() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addComMember(CommonMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addCorMember(CorporateMemberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
