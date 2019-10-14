package com.uas.service;

import java.util.List;

import com.uas.beans.Application;
import com.uas.dao.MACdao;
import com.uas.dao.MACdaoImpl;

public class MACserviceImpl implements MACservice {
	
	MACdao mac=null;
	
	public MACserviceImpl() {
		mac= new MACdaoImpl();
	}

	@Override
	public void showDetails() {
		 mac.showDetails();
	}

	@Override
	public int updateStatus(int app_id, String status) {
		
		return mac.updateStatus(app_id, status);
	}

	@Override
	public void updateInterviewDate(int app_id, String date_of_interview) {
		
		 mac.updateInterviewDate(app_id, date_of_interview);
	}

	@Override
	public int confirmationStatus(int idd, String status) {
		return mac.confirmationStatus(idd, status);
	}

	@Override
	public void deleteApplicant(int app_id) {
		mac.deleteApplicant(app_id);
	}

}
