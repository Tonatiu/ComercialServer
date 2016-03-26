package interfaces.clientuser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;

public interface ClientsInterface extends Remote{
	public boolean Buy(int id_product, int quantity) throws RemoteException;
	public ResultSet GetProductList() throws RemoteException;
}
