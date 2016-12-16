package po;

import java.io.Serializable;
import java.util.Date;

import util.RoomCondition;

public class RoomConditionDatePO implements Serializable{
	    //酒店id
		String hotel_id;

		

		//房间预定住宿时间
		String RoomDate;

			

		//房间编号
		String RoomNumber;

			

		//房间状态״̬
		RoomCondition roomcondition;
		
		
		//订单编号
		String order_id;

			

		public RoomConditionDatePO(){

				

		}

			

		public RoomConditionDatePO(String hotel_id,String rd, String rn, RoomCondition rc, String or){

			

		    this.hotel_id = hotel_id;	

		    this.RoomDate = rd;

		    this.RoomNumber = rn;

		    this.roomcondition = rc;

		    this.order_id = or;
				

		}

		

		public void setOrder_id(String order_id){
			
			this.order_id = order_id;
			
		}

		public void setHotel_id(String hotel_id){

			this.hotel_id = hotel_id;

		}

		

		

		public void setRoomDate(String rd){

			RoomDate = rd;

		}

		

		public void setRoomNumber(String rn){

			RoomNumber = rn;

		}

		

		public void setRoomConditon(RoomCondition rc){

			roomcondition = rc;

		}


		public String getOrder_id(){
			return order_id;
		}
		
		public String getHotel_id(){

			return hotel_id;

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
