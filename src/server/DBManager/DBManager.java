package server.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnector.*;

public class DBManager {
	protected DBConnector conector;
	protected Connection connection;
	protected Statement statement;
	protected ResultSet result;
	
	public void Connect() throws ClassNotFoundException, SQLException{
		this.conector = new DBConnector();
		this.connection = this.conector.getConnection();
		this.statement = this.connection.createStatement();
	}
	
	public void Close() throws SQLException{
		this.statement.close();
		this.connection.close();
		this.conector.close();
	}
}
