package po;

import util.ListType;

public class OrderPO {
	String user_id;
	String order_id;
	String startTime;
	String endTime;
	String deadline;
	String executeTime;
	int people;
	boolean hasChild;
	ListType listType;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public ListType getListType() {
		return listType;
	}
	public void setListType(ListType listType) {
		this.listType = listType;
	}
	//各种可能用到的构造函数
	public OrderPO(){
		
	}
	public OrderPO(String user_id,String order_id,String startTime,String endTime,String deadline,String executeTime,int people,boolean hasChild){
		this.user_id=user_id;
		this.order_id=order_id;
		this.deadline=deadline;
		this.endTime=endTime;
		this.executeTime=executeTime;
		this.hasChild=hasChild;
		this.people=people;
		this.startTime=startTime;
	}
	public OrderPO(OrderPO order,String type){
		
	}
	public OrderPO(String order_id){
		
	}
	
	//各种get和set
	
	public OrderPO getOrderPO(String order_id){
		return this;
	}
	public String getUserName(){
		return user_id;
	}
	public String getOrderID(){
		return order_id;
	}
	public String getDeadline(){
		return deadline;
	}
	public String getExecuteTime(){
		return executeTime;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getEndTime(){
		return endTime;
	}
	public int getPeople(){
		return people;
	}
	public boolean getHasChild(){
		return hasChild;
	}
	
	public void setUserName(String user_id){
		this.user_id=user_id;
	}
	public void setOrderID(String order_id){
		this.order_id=order_id;
	}
	public void setDeadline(String deadline){
		this.deadline=deadline;
	}
	public void setExecuteTime(String executeTime){
		this.executeTime=executeTime;
	}
	public void setStartTime(String startTime){
		this.startTime=startTime;
	}
	public void setEndTime(String endTime){
		this.endTime=endTime;
	}
	public void setPeople(int people){
		this.people=people;
	}
	public void setHasChild(boolean hasChild){
		this.hasChild=hasChild;
	}
	
}
