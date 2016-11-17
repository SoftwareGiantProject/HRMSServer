package dataservice.memberdataservice;

import po.*;
import util.*;

public interface MemberDataService {

	public ResultMessage addCommonMember(String user_id,String birthday);
	public int find(ClientPO client);
	public String commonMemberCreateNumber(CommonMemberPO member);
	public ResultMessage addCorporateMember(String user_id,String corporate,String birthday);
	
}
