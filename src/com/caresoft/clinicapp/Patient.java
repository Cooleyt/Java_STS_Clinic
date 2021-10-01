package com.caresoft.clinicapp;
import java.util.Random;
import java.util.Date;
import java.util.ArrayList;

public class Patient extends User implements PHIComplaintUser {
    
    private String firstName;
    private String lastName;
    private int pin;
    
    public Physician primaryCarePhysician;
    private ArrayList<Integer> currentPrescriptionsByRX;
    public int providerCode;
    public int memberNumber;
    private PatientRecord medicalHistory;
    
    
    public boolean requestAppointment(Date date, Physician doctor) {
        boolean successfullyAdded = false;
        return successfullyAdded;
    }
    void addChartNotes(String notes) {
        this.medicalHistory.getCharts().add(notes);
    }
    
    @Override
    public boolean isAuthorized(Integer confirmedAuthID) {
    	return false;
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
    
    public int getPin() {
    	return pin;
    }
    
    public void setPin(int pin) {
    	this.pin = pin;
    }
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Physician getPrimaryCarePhysician() {
		return primaryCarePhysician;
	}
	public void setPrimaryCarePhysician(Physician primaryCarePhysician) {
		this.primaryCarePhysician = primaryCarePhysician;
	}
	public ArrayList<Integer> getCurrentPrescriptionsByRX() {
		return currentPrescriptionsByRX;
	}
	public void setCurrentPrescriptionsByRX(ArrayList<Integer> currentPrescriptionsByRX) {
		this.currentPrescriptionsByRX = currentPrescriptionsByRX;
	}
	public int getProviderCode() {
		return providerCode;
	}
	public void setProviderCode(int providerCode) {
		this.providerCode = providerCode;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public PatientRecord getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(PatientRecord medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
    
    
}