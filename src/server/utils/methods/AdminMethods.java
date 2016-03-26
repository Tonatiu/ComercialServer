package server.utils.methods;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import interfaces.adminuser.AdminsInterface;
import server.DBManager.Managers.AdminsManager;
import server.DBManager.Managers.ItemsManager;

public class AdminMethods extends UnicastRemoteObject implements AdminsInterface{
	private ItemsManager Imanager;
	private AdminsManager Amanager;
	
	private static final long serialVersionUID = 1L;

	protected AdminMethods() throws RemoteException {
		super();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean AddItem(String name, double price) throws RemoteException {
		boolean result;
		try {
			result = this.Imanager.AddItem(name, price);
		} catch (ClassNotFoundException | SQLException e) {
			result = false;
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public boolean StockMovement(int id_product, boolean movementTipe, int quantity) throws RemoteException {
		boolean result;
		try {
			result = this.Imanager.StockMovement(id_product, movementTipe, quantity);
		} catch (ClassNotFoundException | SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean UpdateItemName(int id_product, String newName) throws RemoteException {
		boolean result;
		try {
			result = this.Imanager.UpdateItemName(id_product, newName);
		} catch (ClassNotFoundException | SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean UpdateItemPrice(int id_product, double price) throws RemoteException {
		boolean result;
		try {
			result = this.Imanager.UpdateItemPrice(id_product, price);
		} catch (ClassNotFoundException | SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean Loggin(String email, String passwd) throws RemoteException {
		boolean result;
		try {
			result = this.Amanager.Loggin(email, passwd);
		} catch (ClassNotFoundException | SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

}
