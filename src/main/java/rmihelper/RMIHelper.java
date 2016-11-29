package rmihelper;

import java.io.BufferedInputStream;
import java.rmi.server.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import org.xml.sax.InputSource;

import data.datafactoryMysqlImpl.DatabaseFactoryMysqlImpl;
import dataservice.datafactory.DataFactory;

public class RMIHelper {
	
	private final int port = 8888;
	
	private String address;
	
	private Registry registry;
	
	private DataFactory dataFactory;
	
	private static RMIHelper helper = new RMIHelper();
	
	private RMIHelper(){
		registry = null;
		address = getIpAddress();
		dataFactory = DatabaseFactoryMysqlImpl.getInstance();
	}
	
	
	public static RMIHelper getInstance(){
		return helper;
	}
	
	public void start(){
		if(registry == null){
			try{
				registry = LocateRegistry.createRegistry(port);
				Naming.bind(dealServerName(port, address), dataFactory);
				Start.sendMessage("Server Open Successfully\r\n"
									+"IP:" + address + "\r\n" 
									+"Port:" + port + "\r\n");
			}catch(RemoteException | MalformedURLException |AlreadyBoundException e ){
				Start.sendMessage("Fail to Open the Server!");
				e.printStackTrace();
			}
		}
		else{
			Start.sendMessage("Server Opened Already");
		}
	}
	
	
	public void restart(){
		off();
		address = getIpAddress();
		start();
	}
	
	public void off(){
		if(registry != null){
			try{
				Naming.unbind(dealServerName(port, address));
				UnicastRemoteObject.unexportObject(registry	, true);
				registry = null;
				Start.sendMessage("Server closed Successfully");
			}catch(MalformedURLException | RemoteException | NotBoundException e){
				e.printStackTrace();
				Start.sendMessage("Fail to close Server");
			}
		}
		else{
			Start.sendMessage("No Server found");
		}
	}

	private String dealServerName(int port, String ip) {
		return "rmi://"+ ip + ":"+port+"/DataFactory";
	}
	
	private String getIpAddress(){
		String ip = null;
		try{
			ip = InetAddress.getLocalHost().getHostAddress();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		
		return ip;
	}
	
	/*
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
	*/
}
