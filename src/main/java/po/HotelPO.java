package po;

public class HotelPO {

	//id
	String hotel_id;
	
	//酒店名称
	String hotel_name;
	
	//酒店地址ַ
	String hotel_address;
	
	//酒店所属商圈
	String hotel_area;
	
	//酒店简介
	String hotel_intro;
	
	//酒店设施服务
	String hotel_serve;
	
	//酒店客房类型
	String hotel_room;
	
	
	public HotelPO(String hotel_id,String hotel_name,String hotel_address,String hotel_area,String hotel_intro,
			String hotel_serve,String hotel_room){
		this.hotel_id = hotel_id;
		this.hotel_address = hotel_address;
		this.hotel_area = hotel_area;
		this.hotel_intro = hotel_intro;
		this.hotel_name = hotel_name;
		this.hotel_room = hotel_room;
		this.hotel_serve = hotel_serve;
	}
	
	public String getHotelId(){
		return hotel_id;
	}
	
	public void setHotelId(String hotel_id){
		this.hotel_id = hotel_id;
	}
	public String getHotelName(){
		return hotel_name;
	}
	
	public void setHotelName(String hotel_name){
		this.hotel_name = hotel_name;
	}
	
	public String getHotelAddress(){
		return hotel_address;
	}
	
	public void setHotelAddress(String hotel_address){
		this.hotel_address = hotel_address;
	}
	
	public String getHotelArea(){
		return hotel_address;
	}
	
	public void setHotelArea(String hotel_area){
		this.hotel_area = hotel_area;
	}
	
	public String getHotelIntro(){
		return hotel_intro;
	}
	
	public void setHotelIntro(String hotel_intro){
		this.hotel_intro = hotel_intro;
	}
	
	public String getHotelRoom(){
		return hotel_room;
	}
	
	public void setHotelRoom(String hotel_room){
		this.hotel_room = hotel_room;
	}
	
	public String getHotelServe(){
		return hotel_serve;
	}
	
	public void setHotelServe(String hotel_serve){
		this.hotel_serve = hotel_serve;
	}
	                                              
}
