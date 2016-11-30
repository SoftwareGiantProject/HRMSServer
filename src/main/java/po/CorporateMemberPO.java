package po;

import util.MemberType;

public class CorporateMemberPO {

	//企业会员等级
	int CorporateMember_level;
		
	//企业会员生日
	String CorporateMember_Birthday;
		
	//企业会员编号
	String CorporateMember_number;
		
	//企业名称
	String Corporate;
	
	//会员类型
	MemberType Member_type;
	
	
	public CorporateMemberPO(int corl, String corbir, String corn, String cor, MemberType mt){
		CorporateMember_level = corl;
		CorporateMember_Birthday = corbir;
		CorporateMember_number = corn;
		Corporate = cor;
		Member_type = mt;
	}
	
	public CorporateMemberPO(){
		
	}
	
	public void setCorporateMember_level(int corl){
		this.CorporateMember_level = corl;
	}
	
	public void setCorporateMember_Birthday(String corbir){
		this.CorporateMember_Birthday = corbir;
	}
	
	public void setCorporateMember_number(String corn){
		this.CorporateMember_number = corn;
	}
	
	public void setCorporate(String cor){
		this.Corporate = cor;
	}
	
	public void setMemberType(MemberType mt){
		this.Member_type = mt;
	}
	
	
	public int getCorporateMember_level(){
		return CorporateMember_level;
	}
	
	public String getCorporateMember_Birthday(){
		return CorporateMember_Birthday;
	}
	
	public String getCorporateMember_number(){
		return CorporateMember_number;
	}
	
	public String getCorporate(){
		return Corporate;
	}
	
	public MemberType getMember_Type(){
		return Member_type;
	}


}

