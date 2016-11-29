package rmihelper;

import java.io.BufferedInputStream;
import java.rmi.server.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import org.xml.sax.InputSource;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.datafactory.DataFactory;

public class ServerRunner {
	
	private static String RMI_PORT = null;
	private static String RMI_ADDRESS = null;
	
	private static DataFactory dataFactory = DatabaseFactoryMysqlImpl.getInstance();
	 
	static{
		Properties prop = new Properties();
		try{
			InputStream in = new BufferedInputStream(new FileInputStream("hrms.properties"));
			prop.load(in);
			RMI_PORT = prop.getProperty("rmi_port");
			RMI_ADDRESS = prop.getProperty("rmi_address");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try{
			LocateRegistry.createRegistry(Integer.parseInt(RMI_PORT));
			Naming.bind("rmi://" + RMI_ADDRESS + ":" + RMI_PORT + "/DataFactory",dataFactory);
		}catch (RemoteException e) {
			e.printStackTrace();
		}catch(AlreadyBoundException e){
			e.printStackTrace();
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
		
	}
}
