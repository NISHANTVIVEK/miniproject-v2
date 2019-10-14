package com.uas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.uas.beans.Program;
import com.uas.util.ConnectionFactory;

public class AdminDaoImpl implements AdminDao {
	ConnectionFactory conFactory = ConnectionFactory.getInstance();
	public void adddetails(Program prg)
	{
		
		String queryString = "INSERT INTO PROGRAMS_OFFERED( ProgramName,description,applicant_eligibility, duration , degree_certificate_offered )VALUES(?,?,?,?,?) ";
		
		try (Connection conn = conFactory.getConnection();
				PreparedStatement ptmt = conn.prepareStatement(queryString);
				) {
			ptmt.setString(1, prg.getProgram() );
			ptmt.setString(2, prg.getDescription());
			ptmt.setString(3, prg.getEligibility());
			ptmt.setInt(4, prg.getDuration());
			ptmt.setString(5, prg.getDegree());
			int rows = ptmt.executeUpdate();
			System.out.println(rows + "Program INSERTED successfully....");
			
		}
		 catch (SQLException e) {
			System.err.format("SQL State:%s\n%s", e.getSQLState(), e.getMessage());
		}
		
		
	}
	
	public void deleteDetails(String p)
	{
		String queryString = "DELETE FROM PROGRAMS_OFFERED WHERE ProgramName=?";
		try (Connection conn = conFactory.getConnection();
				PreparedStatement ptmt = conn.prepareStatement(queryString);
				) {
			ptmt.setString(1, p);
			System.out.println(p);
			int rows = ptmt.executeUpdate();
			System.out.println(rows + "Program DELETED successfully....");	
		}
		 catch (SQLException e) {
			System.err.format("SQL State:%s\n%s", e.getSQLState(), e.getMessage());
		}
		
		
	}
	

}
