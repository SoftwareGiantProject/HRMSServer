package dataservice.memberdataservice;

import po.*;
import util.*;

public interface MemberDataService {

	public ResultMessage addCommonMember(String user_id,String birthday);
	public ResultMessage addCorporateMember(String user_id,String corporate,String birthday);
	
	public String commonMemberCreateNumber(CommonMemberPO member);
	public String corporateMemberCreateNumber(CorporateMemberPO member);
	
	public int getCommonMemberLevel(ClientPO client);
	public int getCorporateMemberLevel(ClientPO client);
	
	public MemberType getMemberType(ClientPO client);

}
