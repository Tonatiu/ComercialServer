package server.utils.methods;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdminsServer implements Runnable{
	private AdminMethods metods;
	private Registry reg;
	
	public AdminsServer() throws RemoteException {
		this.metods = new AdminMethods();
	}
	
	@Override
	public void run() {
		try {
			reg = LocateRegistry.createRegistry(3035);
			reg.bind("AdminServer", this.metods);
			System.out.println("Admins Server running");
		} catch (RemoteException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
