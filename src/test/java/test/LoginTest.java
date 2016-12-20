package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.userdataservice.LoginIn;
import util.ResultMessage;

public class LoginTest {

	LoginIn login;
	
	@Before
	public void init(){
		try {
			login = DatabaseFactoryMysqlImpl.getInstance().getLoginData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLogin() throws RemoteException{
		String id1 = "151250061", password1 = "huangyan529";
		String id2 = "w00001", password2 = "123456";
		String id3 = "s001", password3 = "22";
		String id4 = "n001", password4 = "itisnetworker";
		
		assertEquals(ResultMessage.SUCCESS,login.login(id1, password1));
		assertEquals(ResultMessage.FAIL,login.login(id2, password2));
		assertEquals(ResultMessage.FAIL, login.login(id3, password3));
		assertEquals(ResultMessage.SUCCESS,login.login(id4, password4));
	}
}
