package com.uas.service;

import java.util.List;

import com.uas.beans.Application;
import com.uas.beans.Program;


public interface ApplicationService {
	
	public int addApplicationDetails(Application app);
	public List<Program> showDetails();

}
