package server.utils.methods;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.clientuser.*;
import server.DBManager.Managers.ItemsManager;

public class ClientMethods extends UnicastRemoteObject implements ClientsInterface{
	private ItemsManager Imanager;
	
	protected ClientMethods() throws RemoteException {
		super();
		this.Imanager = new ItemsManager();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean Buy(int id_product, int quantity) throws RemoteException {
		boolean result;
		try {
			result = this.Imanager.StockMovement(id_product, false, quantity);
		} catch (ClassNotFoundException | SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultSet GetProductList() throws RemoteException {
		ResultSet result;
		try {
			result = this.Imanager.GetItemsList();
		} catch (ClassNotFoundException | SQLException e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}

}
