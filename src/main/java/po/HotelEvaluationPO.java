package po;

import java.util.Date;

public class HotelEvaluationPO {

	//订单编号	
	String order_id;
	
	//客户编号
	String user_id;
	
	//评价时间
	Date date;
	
	//评价内容
	String data;
	
	//评价星级
	int level;
	
	public HotelEvaluationPO(String order_id, String user_id, Date date, String data, int level){

		this.order_id = order_id;
		this.user_id = user_id;
		this.date = date;
		this.data = data;
		this.level = level;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
