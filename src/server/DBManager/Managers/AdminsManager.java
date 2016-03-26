package server.DBManager.Managers;

import java.sql.SQLException;

import server.DBManager.DBManager;

public class AdminsManager extends DBManager{
	
	public synchronized boolean Loggin(String email, String passwd) throws ClassNotFoundException, SQLException{
		String query = "select email, passwd"
					 + "from users"
					 + "where email = " + email + ";";
		
		super.Connect();
		this.result = this.statement.executeQuery(query);
		
		if(this.result.next() && this.result.getString("passwd").equals(passwd)){
			return true;
		}
		return false;
	}
	
}
