package cit285.book.dao;
import java.sql.*;



// select date from books where name ='JimmyTran';
public class ConnectionDao {

	public static Connection getSQLConnection() throws Exception {
		try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String password="bhcc";
		String url = "jdbc:mysql://localhost:/book_store";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println("Connected to SQL");
		return conn;
		}catch(Exception e) {System.out.println("Error connecting to Databse! "+e);}
		return null;
	}

	public  String getData(String userName) {
		try {
		Connection conn = getSQLConnection(); //gets the connection with mySQL
		Statement getTheData = conn.createStatement(); 
		//command line to get the correspoding user_name information
		ResultSet dataSet = getTheData.executeQuery("Select user_pass from bookstore_client where user_name ='"+userName+"';"); 
		dataSet.next();
		return dataSet.getString("user_pass"); //returns the data with column label user_pass
		}catch(Exception a) {System.out.println("Connection Fail! "+a);}
		return null;
	}

}
