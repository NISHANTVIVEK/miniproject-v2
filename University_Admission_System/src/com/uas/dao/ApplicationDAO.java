package com.uas.dao;

import java.util.List;

import com.uas.beans.Application;
import com.uas.beans.Program;

public interface ApplicationDAO {
	
	public int addApplicationDetails(Application app);
	public List<Program> showDetails();

}
