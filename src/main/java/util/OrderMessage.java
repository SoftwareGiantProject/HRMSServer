package util;

public enum OrderMessage {
	SUCCESS,//成功	
	FAIL,//失败
	ERROR,//出现错误
	
	AVAILABLE,//客房可用
	NOTAVAILABLE,//客房不可用
	EXIST,//想要添加的东西在数据库已存在
	TOO_LONG,//输入的内容过长
	TOO_SHORT,//输入的内容过短
	UNVALID,//输入的内容含有非法字符
	NULL, //输入的内容为空
	NOT_FOUND,//没有找到所需要的数据
	HAS_CHILDREN,//有儿童
	NO_CHILDREN,//无儿童
	
	
	WRONG_ID,//用户id错误
	WRONG_PASSWORD,//密码错误
	

}
