package cit285.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class LogAndRegisterDao {
	public static void insertUserData(String user, String password, String FirstName, String LastName, String CompanyName) {
		try {
			Connection conn = ConnectionDao.getSQLConnection();
			int typer = 1;
			PreparedStatement insert = conn.prepareStatement("Insert into user(UserID,password,FirstName,LastName,CompanyName,Type) values('"+user+"','"+password+"','"+FirstName+"','"+LastName+"','"+CompanyName+"','"+typer+"');");
			insert.executeUpdate();	
			System.out.println("insert user success!");
		}catch(Exception e) {System.out.println("Insert User Fail! "+e);}
		}

	public static void insertUserAddress(String userid, String address,String address2, String city, String state, String zip,String country ) {
		try {

			Connection conn = ConnectionDao.getSQLConnection();
			PreparedStatement insert = conn.prepareStatement("insert into address(UserID,Address1,Address2,City,State,Zip,Country)  values('"+userid+"','"+address+"','"+address2+"','"+city+"','"+state+"','"+zip+"','"+country+"');");
			insert.executeUpdate();
			System.out.println("insert address success!");
		}catch(Exception e) {System.out.println("Insert Address Fail! "+e);}
	}
	public static void insertEmail(String userid,String emailAddress) {
		try {
			Connection conn = ConnectionDao.getSQLConnection();
			PreparedStatement insert = conn.prepareStatement("insert into email(UserID, EmailAddress) values('"+userid+"','"+emailAddress+"');");
			insert.executeUpdate();
			System.out.println("insert email success!");
		}catch(Exception e) {System.out.println("Insert Email Fail!");}
	}
	public static ResultSet getUsers() {
		try{
			
			Connection conn = ConnectionDao.getSQLConnection();
			Statement getUser = conn.createStatement(); //get statement reference
			ResultSet dataUser = getUser.executeQuery("Select UserID,Password,FirstName from user where Type ='1';"); 
			return dataUser;
		}catch(Exception e) {System.out.println("Error fetching USERID from SQL "+e);}
		return null;}
	public static ResultSet getAdmin() {
		try{
	
			Connection conn = ConnectionDao.getSQLConnection();
			Statement getUser = conn.createStatement(); //get statement reference
			ResultSet dataUser = getUser.executeQuery("Select UserID,Password,FirstName from user where Type ='2';"); 
			return dataUser;
		}catch(Exception e) {System.out.println("Error fetching USERID from SQL "+e);}
		return null;}
	}
