package dataservice.userdataservice;

import java.rmi.RemoteException;

import util.ResultMessage;

public interface LoginIn {

	public ResultMessage login(String user_name,String password)throws RemoteException;
}
