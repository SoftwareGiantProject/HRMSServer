package data.memberdata;

import dataservice.memberdataservice.MemberDataService;
import po.ClientPO;
import po.CommonMemberPO;
import util.ResultMessage;

public class MemberDataServiceMysqlImpl implements MemberDataService{

	@Override
	public ResultMessage addCommonMember(String user_id, String birthday) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int find(ClientPO client) {
		// TODO Auto-generated method stub
		return 0;
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

}
