package com.paf.patient.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.paf.patient.bean.Patient;

public class PatientDAO {
	
	public static Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HelthCare_patient", "root", "admin123");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public static String registerPatient(Patient patient) {
		
		String output = null;
		
		try {
			Connection con = getConnection();
			
			String query = "insert into patient_registration values(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, patient.getNic());
			ps.setString(2, patient.getFirstName());
			ps.setString(3, patient.getLastName());
			ps.setString(4, patient.getDob());
			ps.setString(5, patient.getGender());
			ps.setString(6, patient.getEmail());
			ps.setString(7, patient.getPassword());
			
			ps.executeUpdate();
			
			output = "Patient Register Successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			output = "Error in registration process";
		}
		
		return output;
		
	}

}
