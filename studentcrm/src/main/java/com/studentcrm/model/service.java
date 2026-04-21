package com.studentcrm.model;

import java.sql.ResultSet;

public interface service {
	public void connectDb();
	public boolean loginStatus(String email,String password);
	public void saveregistration(String name, String email, String mobile);
	public ResultSet getStudents(); 
	public void deleteRegistration(String email);
	public void updateRegistration(String email, String mobile);
}
