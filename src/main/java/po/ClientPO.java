package po;

import java.io.Serializable;

public class ClientPO implements Serializable{

	//用户编号
		private String userId;
		
		//用户名
		private String userName;
		//密码
		private String password;
		//信用值ֵ
		private int credit;
		//联系方式
		private String contact;
		
		//生日
		private String birthday;
		
		public ClientPO(){
			
		}
		
		public ClientPO(String userId,String userName,
				String password,int credit,String contact){
			super();
			this.userId=userId;
			
			this.userName=userName;
			this.password=password;
			this.credit=credit;
			this.contact=contact;
			
		}
		
		public String getPassword(){
			return password;
		}
		
		public void setPassword(String password){
			this.password=password;
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
			this.userName=contact;
		}
		
		public int getCredit(){
			return credit;
		}
		
		public void setCredit(int credit){
			this.credit=credit;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
}
