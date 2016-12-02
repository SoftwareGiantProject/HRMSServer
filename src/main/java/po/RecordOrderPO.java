package po;

public class RecordOrderPO {

	private String order_id;
	
	private String user_id;
	
	private String hotel_id;
	
	private String hotel_name;
	
	public RecordOrderPO() {
		
	}
	
	public RecordOrderPO(String order_id,String user_id,String hotel_id, String hotel_name){
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.order_id = order_id;
		this.user_id = user_id;
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

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	
	
}
