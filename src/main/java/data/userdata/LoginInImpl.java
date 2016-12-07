package data.userdata;

import java.rmi.RemoteException;

import data.sqlmanager.SqlManager;
import dataservice.userdataservice.LoginIn;
import util.ResultMessage;

public class LoginInImpl implements LoginIn{

	SqlManager salManager = SqlManager.getSqlManager();
	
	public LoginInImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ResultMessage login(String user_name, String password) {
		switch(user_name.charAt(0)){
		case'w'://酒店工作人员
			
			break;
		case'n'://网站管理人员
			break;
		case's'://网站营销人员
			break;
		default://客户
			break;
		}
		
		
		return null;
	}

}
