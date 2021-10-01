package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Physician extends User implements PHIComplaintUser, PHIAdminComplaint{
    
    private HashSet<Patient> patients;
    private ArrayList<String> securityIncidents;
    
    public Physician() {
    	
    }
    
    public void prescribeRXTo(Patient patient, Integer rxNumber) {
        patient.getCurrentPrescriptionsByRX().add(rxNumber);
        this.patients.add(patient);
    }
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    @Override
	public boolean assignPin() {
    	Random random = new Random();
    	int pin = random.nextInt(8999) + 1000;
    	if(pin == 1234 || pin == 4321) {
    		pin += 1;
    	}
    	this.setPin(pin);
    	return true;
    }
	
	@Override
	public boolean isAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.id) {
			return true;
		}
		authIncident();
		return false;
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return null;
	}

	public HashSet<Patient> getPatients() {
		return patients;
	}

	public void setPatients(HashSet<Patient> patients) {
		this.patients = patients;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
}
