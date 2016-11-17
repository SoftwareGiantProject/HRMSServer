package dataservice.userdataservice;

import java.awt.List;
import po.*;
import util.*;

public interface UserDataService {

	public ResultMessage add(ClientPO po);
	public ResultMessage add(WorkerPO po);
	public ResultMessage add(NetsalePO po);
	public ResultMessage add(NetworkerPO po);
	
	public WorkerPO findWorker(String id);
	public ClientPO findClient(String id);
	public NetsalePO findNetsale(String id);
	public NetworkerPO findNetworker(String id);
	
	public ResultMessage modify(ClientPO po);
	public ResultMessage modify(WorkerPO po);
	public ResultMessage modify(NetsalePO po);
	public ResultMessage modify(NetworkerPO po);
	
	public ClientPO clientLogin(String id,String password);
	public WorkerPO workerLogin(String id,String password);
	public NetsalePO netsaleLogin(String id,String password);
	public NetworkerPO networkerLogin(String id,String password);
	
}
