package server.DBManager.Managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import server.DBManager.DBManager;

public class ItemsManager extends DBManager{
	
	public synchronized boolean AddItem(String name, double price) throws ClassNotFoundException, SQLException{
		String query = "insert into Product(name, price)"
					 + "values(" + name + ", " + Double.toString(price) +");";
		
		super.Connect();
		try{
			this.statement.executeUpdate(query);
		}
		catch(SQLException e){
			return false;
		}
		return true;
	}
	
	public synchronized boolean StockMovement(int id_product, boolean movementTipe, int quantity) throws ClassNotFoundException, SQLException{
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String CurrentDate = formater.format(date);
		
		String query = "insert into Movement(id_Product, tipe, quantity, movemet_date)"
					 + "values(" + Integer.toString(id_product) + ", " + 
					 			Boolean.toString(movementTipe) + ", " +
					 			Integer.toString(quantity) + ", " +
					 			CurrentDate + ");";
		
		super.Connect();
		try{
			this.statement.executeUpdate(query);
		}
		catch(SQLException e){
			return false;
		}
		return true;
	}
	
	public synchronized boolean UpdateItemName(int id_product, String newName) throws ClassNotFoundException, SQLException{
		String query = "update Product"
					 + "set name = " + newName
					 + "where id = " + id_product + ";";
		
		super.Connect();
		try{
			this.statement.executeUpdate(query);
		}
		catch(SQLException e){
			return false;
		}
		return true;
	}
	
	public synchronized boolean UpdateItemPrice(int id_product, double price) throws ClassNotFoundException, SQLException{
		String query = "update Product"
					 + "set price = " + price
					 + "where id = " + id_product + ";";
		
		super.Connect();
		try{
			this.statement.executeUpdate(query);
		}catch(SQLException e){
			return false;
		}
		return true;
	}
	
	public synchronized ResultSet GetItemsList() throws ClassNotFoundException, SQLException{
		String query = "select * from product;";
		super.Connect();
		return this.statement.executeQuery(query);
	}
}
