package dataservice.hoteldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import po.*;
import util.*;


public interface HotelDataService extends Remote{


	public HotelPO seekHotel(String hotel_name) throws RemoteException;
	public ArrayList<HotelPO> viewHistoryHotel() throws RemoteException;
	
	public ArrayList<HotelPO> getReservedHotel(String user_id) throws RemoteException;
	public ArrayList<HotelPO> getHotelByArea(String area) throws RemoteException;
	public ArrayList<HotelPO> getHotelByLevel(int level) throws RemoteException;
 	public ArrayList<HotelEvaluationPO> getAllHotelEvaluation(String hotel_name);
 	public ArrayList<HotelPO> getAllHotel(String user_id, String hotel_id);
	
	public ResultMessage addHotel(HotelPO po) throws RemoteException;
	public ResultMessage modifyHotel(HotelPO po) throws RemoteException;
	public ResultMessage evaluateHotel(HotelEvaluationPO po) throws RemoteException;
}
