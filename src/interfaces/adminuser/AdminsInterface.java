package interfaces.adminuser;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminsInterface extends Remote{
	public boolean AddItem(String name, double price) throws RemoteException;
	public boolean StockMovement(int id_product, boolean movementTipe, int quantity) throws RemoteException;
	public boolean UpdateItemName(int id_product, String newName) throws RemoteException;
	public boolean UpdateItemPrice(int id_product, double price) throws RemoteException;
	public boolean Loggin(String email, String passwd) throws RemoteException;
}
