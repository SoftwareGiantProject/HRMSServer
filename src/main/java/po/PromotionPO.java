package po;

public class PromotionPO {
	//促销策略名称
	String promotionName;
	
	//促销对象
	String promotionObject;
	
	//折扣力度
	double count;
	
	//持续时间
	String time;
	
	public PromotionPO(){
		
	}
	public PromotionPO(String promotionName,String promotionObject,double count,String time){
		this.promotionName=promotionName;
		this.promotionObject=promotionObject;
		this.count=count;
		this.time=time;
	}
	
	
	//get��set
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
