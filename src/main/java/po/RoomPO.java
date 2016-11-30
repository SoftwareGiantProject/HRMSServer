package po;

import util.RoomConditon;

public class RoomPO {

	//房间类型
	String Room_type;
		
	//房间价格
	double Room_price;
	
	//房间编号
	String Room_number;
		
	//房间状态
	RoomConditon Room_condition;
	
	//酒店编号
	String Hotel_id;
	
	
	public RoomPO(String rt,double rp, String rnb, RoomConditon rc, String ho){
		
		Room_type = rt;
		Room_price = rp;
		Room_number = rnb;
		Room_condition = rc;
		Hotel_id = ho;
		
	}
	
	public RoomPO(){
		
	}
	
	public void setRoom_type(String rt){
		this.Room_type = rt;
	}
	
	public void setRoom_price(double rp){
		this.Room_price = rp;
	}
	
	public void setRoom_number(String rnb){
		this.Room_number = rnb;
	}
	
	public void setRoom_condition(RoomConditon rc){
		this.Room_condition = rc;
	}
	
	public void setHotel_id(String ho){
		this.Hotel_id = ho;
	}
	
	public String getRoom_type(){
		return Room_type;
	}

	public double getRoom_price(){
		return Room_price;
	}
	
	public String getRoom_number(){
		return Room_number;
	}
	
	public RoomConditon getRoom_condition(){
		return Room_condition;
	}
	
	public String getHotel_id(){
		return Hotel_id;
	}
	
}
