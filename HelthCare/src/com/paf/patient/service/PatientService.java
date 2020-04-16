package com.paf.patient.service;

import com.paf.patient.bean.Patient;
import com.paf.patient.model.PatientDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

@Path("/patient")
public class PatientService {
	
	@POST
	@Path("/patient_registration")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerPatient(@FormParam("nic") String nic,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("dob") String dob,
			@FormParam("gender") String gender,
			@FormParam("email") String email,
			@FormParam("password") String password) {
		
		String status;
		
		Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		status = PatientDAO.registerPatient(p);
		
		return status;
	}
	
	
	
}
