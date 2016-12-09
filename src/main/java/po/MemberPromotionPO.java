package po;

import java.io.Serializable;

public class MemberPromotionPO implements Serializable{

	private String promotionName;
	
	private static String promotionObject = "Member";
	
	private String time;
	
	private double count;
	
	private String area;
	
	public MemberPromotionPO(){
		
	}
	
	public MemberPromotionPO(String name,String time,double count,String area){
		this.promotionName = name;
		this.time = time;
		this.count = count;
		this.area = area;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public static String getPromotionObject() {
		return promotionObject;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
