package po;

import java.util.Date;

import util.RoomCondition;

public class RoomConditionDatePO {
	//酒店id
	String hotel_id;
	
	//房间预定住宿时间
	String RoomDate;
		
	//房间编号
	String RoomNumber;
		
	//房间状态״̬
	RoomCondition roomcondition;
		
	public RoomConditionDatePO(){
			
	}
		
	public RoomConditionDatePO(String hotel_id,String rd, String rn, RoomCondition rc){
		
	    this.hotel_id = hotel_id;	
	    this.RoomDate = rd;
	    this.RoomNumber = rn;
	    this.roomcondition = rc;
			
	}
	
	
	public void setHotel_id(String hotel_id){
		this.hotel_id = hotel_id;
	}
	
	public String getHotel_id(){
		return hotel_id;
	}
	
	public void setRoomDate(String rd){
		RoomDate = rd;
	}
	
	public void setRoomNumber(String rn){
		RoomNumber = rn;
	}
	
	public void setRoomCondition(RoomCondition rc){
		roomcondition = rc;
	}
	    
	public String getRoomDate(){
	   return RoomDate;
	}
	    
	public String getRoomNumber(){
	   return RoomNumber;
	}
	    
	public RoomCondition getRoomCondition(){
	   return roomcondition;
	}

}
