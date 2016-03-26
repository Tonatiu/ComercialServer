package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static Connection connection;
	private String server = "jdbc:mysql://localhost/banco";
	private String user = "root";
	private String passwd = "123456";
	private String driver = "com.mysql.jdbc.Driver";
	
	public DBConnector() throws ClassNotFoundException, SQLException{
		Class.forName(this.driver);
		this.connection = DriverManager.getConnection(server, user, passwd);
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public void close() throws SQLException{
		this.connection.close();
	}
}
