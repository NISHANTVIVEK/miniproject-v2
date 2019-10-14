package com.uas.service;

import com.uas.dao.LoginDao;
import com.uas.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	LoginDao dao =new LoginDaoImpl();
	public String authenticate(String user,String pass)
	{
		return dao.authenticate(user, pass);
	}

}
