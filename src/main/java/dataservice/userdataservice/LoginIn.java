package dataservice.userdataservice;

import util.ResultMessage;

public interface LoginIn {

	public ResultMessage login(String user_name,String password);
}
