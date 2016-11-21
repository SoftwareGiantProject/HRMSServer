package data.memberdata;

import dataservice.memberdataservice.MemberDataService;
import po.ClientPO;
import po.CommonMemberPO;
import po.CorporateMemberPO;
import util.MemberType;
import util.ResultMessage;

public class MemberDataServiceMysqlImpl implements MemberDataService{

	@Override
	public ResultMessage addCommonMember(String user_id, String birthday) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String commonMemberCreateNumber(CommonMemberPO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addCorporateMember(String user_id, String corporate, String birthday) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String corporateMemberCreateNumber(CorporateMemberPO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCommonMemberLevel(ClientPO client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCorporateMemberLevel(ClientPO client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberType getMemberType(ClientPO client) {
		// TODO Auto-generated method stub
		return null;
	}

}
