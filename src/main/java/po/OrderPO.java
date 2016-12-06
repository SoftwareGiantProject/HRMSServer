package po;

import util.ListType;

public class OrderPO {
	private String user_id;
	private String order_id;
	private String hotel_id;
	private String startTime;
	private String endTime;
	private String deadline;
	private String executeTime;
	private String predictCheckInTime;
	private String predictCheckOutTime;
	private String roomType;
	private int number;
	private int people;
	private boolean hasChild;
	private ListType listType;

	//各种可能用到的构造函数
	public OrderPO(){
		
	}
	public OrderPO(String user_id,String order_id,String hotel_id,String startTime,String endTime,String deadline,String executeTime,int people,boolean hasChild){
		this.user_id=user_id;
		this.order_id=order_id;
		this.hotel_id=hotel_id;
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
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPredictCheckInTime() {
		return predictCheckInTime;
	}
	public void setPredictCheckInTime(String predictCheckInTime) {
		this.predictCheckInTime = predictCheckInTime;
	}
	public String getPredictCheckOutTime() {
		return predictCheckOutTime;
	}
	public void setPredictCheckOutTime(String predictCheckOutTime) {
		this.predictCheckOutTime = predictCheckOutTime;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getExecuteTime() {
		return executeTime;
	}
	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public ListType getListType() {
		return listType;
	}
	public void setListType(ListType listType) {
		this.listType = listType;
	}

	
	
}
