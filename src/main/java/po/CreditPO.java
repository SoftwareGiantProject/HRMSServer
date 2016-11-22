package po;

import java.io.Serializable;

public class CreditPO implements Serializable{

	String userId;
	int credit;
	String time;
	int change;
	
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

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public int getChange() {
	return change;
}

public void setChange(int change) {
	this.change = change;
}

}
