package com.studentcrm.model;

import java.sql.*;

public class DBServiceImpl implements service {
	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentcrm","root","toor");
			stmnt=con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean loginStatus(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			if(result.next()) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
      
	@Override
	public void saveregistration(String name, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+email+"','"+mobile+"')"); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getStudents() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteRegistration(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update registration set mobile='"+mobile+"' where email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
