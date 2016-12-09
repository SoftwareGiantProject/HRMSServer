package po;

import java.io.Serializable;

import util.RoomCondition;

public class RoomPO implements Serializable{

	//房间类型
	String Room_type;
		
	//房间价格
	int Room_price;
	
	//房间编号
	String Room_number;
		
	//房间状态
	RoomCondition Room_condition;
	
	//酒店编号
	String Hotel_id;
	
	
	public RoomPO(String rt,int rp, String rnb, RoomCondition rc, String ho){
		
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
	
	public void setRoom_price(int rp){
		this.Room_price = rp;
	}
	
	public void setRoom_number(String rnb){
		this.Room_number = rnb;
	}
	
	public void setRoom_condition(RoomCondition rc){
		this.Room_condition = rc;
	}
	
	public void setHotel_id(String ho){
		this.Hotel_id = ho;
	}
	
	public String getRoom_type(){
		return Room_type;
	}

	public int getRoom_price(){
		return Room_price;
	}
	
	public String getRoom_number(){
		return Room_number;
	}
	
	public RoomCondition getRoom_condition(){
		return Room_condition;
	}
	
	public String getHotel_id(){
		return Hotel_id;
	}
	
}
