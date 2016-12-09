package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import data.sqlmanager.SqlManager;
import dataservice.userdataservice.LoginIn;
import util.ResultMessage;

public class LoginInImpl extends UnicastRemoteObject  implements LoginIn{

	SqlManager sqlManager = SqlManager.getSqlManager();
	
	public LoginInImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage login(String user_name, String password)throws RemoteException {
		
		sqlManager.getConnection();
		Map<String,Object> map = new HashMap<>();
		
		switch(user_name.charAt(0)){
		case'w'://酒店工作人员
			String sql1 = "SELECT password FROM worker WHERE id=?";
			
			map = sqlManager.querySimple(sql1, new Object[]{user_name});
			break;
		case'n'://网站管理人员
			String sql2 = "SELECT password FROM networker WHERE id=?";
			
			map = sqlManager.querySimple(sql2, new Object[]{user_name});
			break;
		case's'://网站营销人员
			String sql3 = "SELECT password FROM netsale WHERE id=?";
			
			map = sqlManager.querySimple(sql3, new Object[]{user_name});
			break;
		default://客户
			String sql4 = "SELECT password FROM client WHERE id=?";
			
			map = sqlManager.querySimple(sql4, new Object[]{user_name});
			break;
		}
		
		String correctPassword = map.get("password").toString();
		
		sqlManager.releaseAll();
		if(password.equals(correctPassword)){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAIL;
		}
		
	}

}
