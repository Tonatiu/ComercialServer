package server.app;

import java.io.IOException;
import server.utils.methods.AdminsServer;
import server.utils.methods.ClientsServer;

public class Main {
	public static void main(String[] args) throws IOException{
		AdminsServer Aserver = new AdminsServer();
		ClientsServer Cserver = new ClientsServer();
		
		new Thread(Aserver).start();
		new Thread(Cserver).start();
	}
}
