package com.uas.ui;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.uas.beans.Application;
import com.uas.service.ApplicationService;
import com.uas.service.ApplicationServiceImpl;
import com.uas.service.MACservice;
import com.uas.service.MACserviceImpl;

public class MainUI {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = null;
		int choice;
		Application app = new Application();

		ApplicationService appServ = new ApplicationServiceImpl();
		
		MACservice mac = new MACserviceImpl();

		do {
			System.out.println("===Welcome to University Admission System  ===");
			System.out.println("Enter Choice:");
			System.out.println("1.Do You Want To Apply for a Course");
			System.out.println("2.Login");
			//System.out.println("3.Administrator");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				appServ.showDetails();	//write program for showing returned list
				int id_seq = app.getApp_id();
				System.out.println("enter Applicant's full name:");
				input = sc.next();
				app.setFull_name(input);
				System.out.println("enter date of birth");
				input = sc.next();
				app.setDob(input);

				System.out.println("Choose Highest Qualification");
				System.out.println("1.B.tech");
				System.out.println("2.M.tech");
				System.out.println("select choice....");
				int c = sc.nextInt();
				switch (c) {
				case 1:
					app.setHighest_qualification("B.tech");
					System.out.println("Selected choice B.tech");
					break;
				case 2:
					app.setHighest_qualification("M.tech");
					System.out.println("Selected choice M.tech");
					break;
				default:
					System.out.println("invalid choice");
					break;
				}

				System.out.println(" Enter Marks obtained in Highest Qualification in percent:");
				int m = sc.nextInt();
				app.setMarks(m);

				System.out.println("enter your goals");
				input = sc.next();
				app.setGoals(input);

				System.out.println("enter your email-id");
				input = sc.next();
				app.setEmail(input);

				//iNCREASE THE VARCHARVALUE IN SQL
				
				
				System.out.println("enter Scheduled_Program_id ");// later change it
				input = sc.next();
				app.setSch_prog_id(input);
				
				System.out.println("current  status : applied");
				input = "applied";
				app.setStatus(input);
				
				System.out.println("date of interview....stting");
				input = "none";
				app.setDate_of_interview(input);
				int rows=appServ.addApplicationDetails(app);
				//System.out.println(rows+ "inserted");
				 
//				System.out.println("showing  table details....");
//			
				mac.showDetails();
			
//			System.out.println("select id");
//			int idd= sc.nextInt();
//			mac.updateStatus(idd, app.getStatus());
//			System.out.println("show updated table.................");
			//mac.updateInterviewDate("accept", app.getDate_of_interview());
			
			
			
				/*System.out.println("choose id for status");
				int new_id= sc.nextInt();
				System.out.println("setting status...");**/
				
				//mac.updateStatus(new_id, app.getStatus());
			 
	
				//mac.updateStatus(app.getApp_id();app.getSch_prog_id());
				

				

				
				
				//int rows=appServ.addApplicationDetails(app);
				break;
			case 2:
				LoginUI login =new LoginUI();
				login.getLogin();
				break;

			    

			case 3:
				System.exit(0);
				break;
			default:
				break;

			}

		} while (choice != 4);
		System.out.println("_Main->end...");
	}
}
