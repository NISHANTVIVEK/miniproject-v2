package com.uas.service;

import com.uas.dao.LoginDao;
import com.uas.dao.LoginDaoImpl;

public interface LoginService {
	
public String authenticate(String user ,String pass);

}
