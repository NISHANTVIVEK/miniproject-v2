package com.uas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uas.util.ConnectionFactory;

public class LoginDaoImpl implements LoginDao {
	ConnectionFactory conFactory = ConnectionFactory.getInstance();
	public String authenticate(String user ,String pass)
	{
		String SQL1 = "SELECT * FROM LOGIN WHERE login_id=? AND password = ? ";
		String role1 = null;
		try (Connection conn = conFactory.getConnection();
				PreparedStatement pstat = conn.prepareStatement(SQL1);) {
			pstat.setString(1, user);
			pstat.setString(2, pass);
			int rows = pstat.executeUpdate();
			ResultSet rs = pstat.executeQuery(SQL1);
			while(rs.next())
			{
			
			 role1 = rs.getString("role");
			}
			

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return role1;
	}

}
