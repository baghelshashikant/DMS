package com.dms.dao;

import java.util.List;

import com.dms.model.Patient;

public interface PatientDao 
{
	 public boolean savepatient(Patient patient);
	  
	  Patient getPatientbyName(String patientName); 
	  
	  boolean deltePatient(Patient patient);
	  
	  boolean modifyPatient(Patient patient);
	  
	  List<String> getPatientNames();
	  
	  List<String> getPhonenumberListByName(String patientName);
	  
	  List<Patient> getTodayAppointmentPatient();
}
