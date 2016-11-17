package po;

import java.io.Serializable;

public class CreditPO implements Serializable{

	String userId;
	int credit;
	
public CreditPO() {
	// TODO Auto-generated constructor stub
}

public CreditPO(String userId,int credit){
	super();
	this.userId=userId;
	
	this.credit=credit;
	
}

public String getId(){
	return userId;
}

public void setId(String userId){
	this.userId = userId;
}

public int getCredit(){
	return credit;
}

public void setCredit(int credit){
	this.credit = credit;
}

}
