package po;


import java.util.ArrayList;

public class ListPO {
	
	ArrayList<OrderPO>   list=new ArrayList<>();
	String user_id;
	String type;
	
	//构造函数
	public ListPO(){
		
	}
	public ListPO(String user_id,String type){
		
	}
	
	//get set
	public ListPO getListPO(String ListType){
		return this;
	}
	public ArrayList<OrderPO> getList(String type){
		
		return list;
	}
	public void setList(OrderPO order){
		
	}
	
}
