package com.paf.patient.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.paf.patient.model.Patient;

public class PatientDAO {
	
	public Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HelthCare_patient", "root", "admin123");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public String registerPatient(Patient p) {
		
		String output = null;
		
		try {
			Connection con = getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
		
	}

}
