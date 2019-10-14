package com.uas.dao;

import java.util.List;

import com.uas.beans.Application;

public interface MACdao {

	void showDetails();
	int updateStatus(int app_id,String status);
	void updateInterviewDate(int app_id,String date_of_interview);
	int confirmationStatus(int app_id, String status);
	void deleteApplicant(int app_id);
}
