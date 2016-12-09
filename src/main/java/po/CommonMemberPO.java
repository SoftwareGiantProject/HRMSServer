package po;

import java.io.Serializable;

import util.MemberType;

public class CommonMemberPO implements Serializable{

	//普通会员等级
	int CommonMember_level; 
		
	//普通会员生日
	String CommonMember_Birthday;
		
	//普通会员编号
	String CommonMember_number;
	
	//会员类型
	MemberType Member_type;
	
	
	public CommonMemberPO(int coml, String combir, String comn, MemberType mt){
		CommonMember_level = coml;
		CommonMember_Birthday = combir;
		CommonMember_number = comn;
		Member_type = mt;
	}
	
	
	public CommonMemberPO(){
		
	}
	
	public void setCommonMember_level(int coml){
		this.CommonMember_level = coml;
	}
	
	public void setCommonMember_Birthday(String combir){
		this.CommonMember_Birthday = combir;
	}
	
	public void setCommonMember_number(String comn){
		this.CommonMember_number = comn;
	}
	
	public void setMember_type(MemberType mt){
		this.Member_type = mt;
	}
	
	
	public int getCommonMember_level(){
		return CommonMember_level;
	}
	
	public String getCommonMember_Birthday(){
		return CommonMember_Birthday;
	}
	
	public String getCommonMember_number(){
		return CommonMember_number;
	}
	
	public MemberType getMember_type(){
		return Member_type;
	}

}
