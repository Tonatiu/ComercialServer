package server.utils.methods;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientsServer implements Runnable{
	private ClientMethods methods;
	private Registry reg;
	
	public ClientsServer() throws RemoteException {
		this.methods = new ClientMethods();
	}
	
	@Override
	public void run() {
		try {
			this.reg = LocateRegistry.createRegistry(3036);
			reg.bind("ClientsServer", this.methods);
			System.out.println("Clients Server ready");
		} catch (RemoteException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
