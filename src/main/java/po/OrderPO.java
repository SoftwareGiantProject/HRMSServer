package po;

import java.io.Serializable;

import util.ListType;

public class OrderPO implements Serializable{
	//客户编号
	private String user_id;
    
	//订单编号
	private String order_id;

	//酒店编号
	private String hotel_id;

	//下订单的时间
	private String startTime;

	//退房时间
	private String endTime;

	//最晚执行时间
	private String deadline;

	//订单执行时间(当撤销订单时，成为撤销订单时间)
	private String executeTime;

	//预计入住时间
	private String predictCheckInTime;

	//预计离开时间
	private String predictCheckOutTime;

	//房间类型
	private String roomType;

	//房间数量
	private int number;

	//人员数量
	private int people;

	//是否有儿童
	private boolean hasChild;

	//订单类型
	private ListType listType;

	//订单金额
	private int order_price;


	//各种可能用到的构造函数

	public OrderPO(){

	}

	public OrderPO(String user_id,String order_id,String hotel_id,String startTime,String endTime,String deadline,String executeTime,String predictCheckInTime,String predictCheckOutTime,String roomType, int number, int people,boolean hasChild,ListType listType, int order_price){

		this.user_id=user_id;
		this.order_id=order_id;
		this.hotel_id=hotel_id;
		this.startTime=startTime;
		this.endTime=endTime;
		this.deadline=deadline;
		this.executeTime=executeTime;
		this.predictCheckInTime = predictCheckInTime;
		this.predictCheckOutTime = predictCheckOutTime;
		this.roomType = roomType;
		this.number = number;
		this.hasChild=hasChild;
		this.people=people;
		this.listType = listType;
		this.order_price = order_price;

	}

	

	//各种get和set
	
	public void setOrderPrice(int order_price){
		this.order_price = order_price;
	}
	
	public int getOrderPrice(){
		return order_price;
	}

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
