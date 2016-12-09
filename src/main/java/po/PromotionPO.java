package po;

import java.io.Serializable;

public class PromotionPO implements Serializable{
	//促销策略名称
	private String promotionName;
	
	//促销对象
    private String promotionObject;
	
	//折扣力度
	private double count;
	
	//持续时间
	private String time;
	
	//促销策略商家
	private String seller;
	
	public PromotionPO(){
		
	}
	public PromotionPO(String promotionName,String promotionObject,double count,String time){
		this.promotionName=promotionName;
		this.promotionObject=promotionObject;
		this.count=count;
		this.time=time;
	}
	
	
	//get&set
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public PromotionPO getPromotionPO(){
		return this;
	}
	public String getPromotionName(){
		return promotionName;
	}
	public String getPromotionObject(){
		return promotionObject;
	}
	public double getCount(){
		return count;
	}
	public String getTime(){
		return time;
	}
	
	
	
	
	
	public void setPromotionName(String name){
		this.promotionName=name;
	}
	public void setPromotionObject(String Object){
		this.promotionObject=Object;
	}
	public void setCount(double count){
		this.count=count;
	}
	public void setTime(String time){
		this.time=time;
	}
	

}
