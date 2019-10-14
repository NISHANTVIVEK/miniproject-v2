package com.uas.service;

import java.util.List;

import com.uas.beans.Application;

public interface MACservice {

	
	void showDetails();
	int updateStatus(int app_id,String status);
	void updateInterviewDate(int app_id,String date_of_interview); 
	int confirmationStatus(int idd,String status);
	void deleteApplicant(int app_id);
}
