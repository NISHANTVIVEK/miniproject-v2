package com.uas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.uas.beans.Application;

public class MACdaoImpl implements MACdao {
	
	Scanner sc= new Scanner(System.in);
	
	// DB Connection properties...
			String dbDriver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbUsername = "hr";
			String dbPassword = "hr";

			private Connection connection;
			//TrainerDetails trainer=null;
			
			
			
			
			 public  MACdaoImpl() {
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
	public void showDetails() {
		Application app = new Application();
		List<Application> lists = new ArrayList<Application>();
		String SQL = "SELECT * FROM Application ";
		try (Connection connection = getConnection(); Statement stat = connection.createStatement();) {
			ResultSet rs = stat.executeQuery(SQL);
			//System.out.println(rs);
			while (rs.next()) {
				
				app.setApp_id(rs.getInt("Application_id"));
				app.setFull_name(rs.getString("full_name"));
				app.setDob(rs.getString("date_of_birth"));
				app.setHighest_qualification(rs.getString("highest_qualification"));
				app.setMarks(rs.getInt("marks_obtained"));
				app.setGoals(rs.getString("goals"));
				app.setEmail(rs.getString("email_id"));
				app.setSch_prog_id(rs.getString("Scheduled_program_id"));
				app.setStatus(rs.getString("status"));
				app.setDate_of_interview(rs.getString("Date_Of_Interview"));
                lists.add(app);
                
                /*Iterator<Application> it = lists.iterator(); 
                while (it.hasNext()) 
                    System.out.print(it.next() + " "); */
				 System.out.println(lists);
				 

			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateStatus(int app_id, String status) {
		Application app =new Application();
	
		System.out.println("enter the status accept/reject");
		String updated_status=sc.next();
		String SQL = "UPDATE Application SET status = ? WHERE  Application_id=?";
		int rows = 0;
		try (Connection connection = getConnection(); PreparedStatement pstat = connection.prepareStatement(SQL);) {
			
			pstat.setInt(2, app_id);
			pstat.setString(1, updated_status);
			
			rows = pstat.executeUpdate();
			System.out.println("Status updated successfully.....");
			if((updated_status.equals("accept")) && rows > 0) 
			{
			   //System.out.println("inside function interview date");
				 updateInterviewDate(app_id, app.getDate_of_interview());
				//System.out.println("updated date....");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public void updateInterviewDate(int app_id, String date_of_interview) {
		System.out.println("enter the date of interview");
		String updated_date=sc.next();
		String SQL = "UPDATE Application SET Date_Of_Interview = ? WHERE  Application_id=?";
		int rows = 0;
		try (Connection connection = getConnection(); PreparedStatement pstat = connection.prepareStatement(SQL);) {
			
			pstat.setInt(2, app_id);
			pstat.setString(1, updated_date);
			rows = pstat.executeUpdate();
			System.out.println("interview date updated successfully.....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int confirmationStatus(int app_id, String status) {
		Application app =new Application();
	
		System.out.println("enter the status confirm/reject");
		String updated_status=sc.next();
		String SQL = "UPDATE Application SET status = ? , Date_Of_Interview='none' WHERE  Application_id=?";
		int rows = 0;
		try (Connection connection = getConnection(); PreparedStatement pstat = connection.prepareStatement(SQL);) {
			
			pstat.setInt(2, app_id);
			pstat.setString(1, updated_status);
			
			rows = pstat.executeUpdate();
			System.out.println("Status updated successfully.....");
			
			if(updated_status.equals("reject")){
				System.out.println(app_id);
				deleteApplicant(app_id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}



	@Override
	public void deleteApplicant(int app_id) {

		Application app =new Application();

		String SQL = "delete from Application WHERE  Application_id=?";
		int rows = 0;
		try (Connection connection = getConnection(); PreparedStatement pstat = connection.prepareStatement(SQL);) {
			pstat.setInt(1, app_id);
			
			rows = pstat.executeUpdate();
			System.out.println("Applicant deleted successfully.....");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
