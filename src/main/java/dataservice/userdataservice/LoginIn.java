package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import util.ResultMessage;

public interface LoginIn extends Remote{

	public ResultMessage login(String user_name,String password)throws RemoteException;
}
