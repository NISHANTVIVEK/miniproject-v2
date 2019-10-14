package com.uas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uas.beans.Application;
import com.uas.beans.Program;
import com.uas.util.ConnectionFactory;

public class ApplicationDAOImpl implements ApplicationDAO {
	ConnectionFactory conFactory = ConnectionFactory.getInstance();
	
	// DB Connection properties...
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
		String dbUsername = "hr";
		String dbPassword = "hr";

		private Connection connection;
		//TrainerDetails trainer=null;
		
		
		
		
		 public ApplicationDAOImpl() {
			try {
				Class.forName(dbDriver);
				// System.out.println("Driver loaded...");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			
		

		public Connection getConnection() {
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
		
		@Override
		public int addApplicationDetails(Application app) {
			//System.out.println("purchase details dao impl ---save");
			String seqqueryString ="SELECT  SEQ_APPLICATION_ID.NEXTVAL  FROM DUAL";
			String queryString = "INSERT INTO Application" + "(Application_id, full_name,date_of_birth,highest_qualification,marks_obtained,goals,email_id,Scheduled_program_id,status,Date_Of_Interview)"
					+ ""+"VALUES(?,?,?,?,?,?,?,?,?,?)";
			int seqTrainerId = 0;
			int rows;
			
			try(Connection conn = getConnection();
					PreparedStatement pstmt1 = conn.prepareStatement(seqqueryString);
					PreparedStatement pstmt2 = conn.prepareStatement(queryString);) {
				ResultSet rs = pstmt1.executeQuery();
				while(rs.next()) {
					seqTrainerId = rs.getInt(1);
					break;
				}
				rs.close();
				System.out.println("trainer id generated: "+seqTrainerId);
				pstmt2.setInt(1, seqTrainerId);
				pstmt2.setString(2, app.getFull_name());
				pstmt2.setString(3, app.getDob());
				pstmt2.setString(4, app.getHighest_qualification());
				pstmt2.setInt(5,app.getMarks() );
				pstmt2.setString(6, app.getGoals() );
				pstmt2.setString(7, app.getEmail());
				pstmt2.setString(8, app.getSch_prog_id() );
				pstmt2.setString(9, app.getStatus() );
				pstmt2.setString(10, app.getDate_of_interview());
					
					 rows = pstmt2.executeUpdate();
					System.out.println("details inserted successfully in list"+ "id:" +seqTrainerId);
					
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			return seqTrainerId;
		}
		
		public List<Program> showDetails()
		{
			String queryString = "SELECT * FROM PROGRAMS_OFFERED";
			List<Program> list = new ArrayList();
			Program prog = new Program();
			
			try (Connection conn = conFactory.getConnection();
				Statement stmt = conn.createStatement();
					) {
				ResultSet rs = stmt.executeQuery(queryString);
				while(rs.next())
				{
				prog.setProgram(rs.getString("PROGRAMNAME"));
				prog.setDescription(rs.getString("DESCRIPTION"));	
				prog.setEligibility(rs.getString("APPLICANT_ELIGIBILITY"));	
				prog.setDuration(Integer.parseInt(rs.getString("DURATION")));	
				prog.setDegree(rs.getString("DEGREE_CERTIFICATE_OFFERED"));	
				list.add(prog);
				}
			}
			 catch (SQLException e) {
				System.err.format("SQL State:%s\n%s", e.getSQLState(), e.getMessage());
			}
			
			return list;
		}
		

	
}
