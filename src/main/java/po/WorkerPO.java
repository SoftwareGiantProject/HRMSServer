package po;

import java.io.Serializable;

public class WorkerPO implements Serializable{

	//用户编号
		private String userId;
		
		//酒店id
		private String hotel_id;
		//用户名
		private String userName;
		//密码
		private String password;
		
		//联系方式
		private String contact;
		
		public WorkerPO(){
			
		}
		
		public WorkerPO(String userId,String userName,
				String password,String contact){
			super();
			this.userId=userId;
			
			this.userName=userName;
			this.password=password;
			
			this.contact=contact;
			
		}
		
		public String getPassword(){
			return password;
		}
		
		public void setPassword(String password){
			this.password=password;
		}
		
		
		
		public String getHotel_id() {
			return hotel_id;
		}

		public void setHotel_id(String hotel_id) {
			this.hotel_id = hotel_id;
		}

		public String getUserId(){
			return userId;
		}
		
		public void setUserId(String userId){
			this.userId=userId;
		}
		
		
		
		public String getUserName(){
			return userName;
		}
		
		public void setUserName(String userName){
			this.userName=userName;
		}
		
		public String getContact(){
			return contact;
		}
		
		public void setContact(String contact){
			this.contact=contact;
		}
		
		
}
