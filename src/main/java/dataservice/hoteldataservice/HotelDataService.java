package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.*;
import util.*;


public interface HotelDataService {


	public HotelPO seekHotel(String hotel_name) throws RemoteException;
	public ArrayList<HotelPO> viewHistoryHotel() throws RemoteException;
	
	public ResultMessage addHotel(HotelPO po) throws RemoteException;
	public ResultMessage modifyHotel(HotelPO po) throws RemoteException;
	public ResultMessage evaluateHotel(HotelEvaluationPO po) throws RemoteException;
}
