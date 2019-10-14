package com.uas.ui;

import java.util.Scanner;

import com.uas.beans.Application;
import com.uas.beans.Login;
import com.uas.beans.Program;
import com.uas.service.AdminService;
import com.uas.service.AdminServiceImpl;
import com.uas.service.LoginService;
import com.uas.service.LoginServiceImpl;
import com.uas.service.MACservice;
import com.uas.service.MACserviceImpl;

public class LoginUI {
	 void getLogin()
		{
		String user,pass,role;
		Application app = new Application();
		MACservice mac = new MACserviceImpl();
		Program prg =new Program();
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter valid username");
		user =sc.next();
		System.out.println("Enter valid password");
		pass=sc.next();
		Login l =new Login(user,pass);
		LoginService obj = new LoginServiceImpl();
		role =obj.authenticate(user,pass);
		System.out.println(role);
		if(role.equals("MAC"))
		{
			
			System.out.println("MAC");
			mac.showDetails();
			
			System.out.println("Enter 1 for updating the status of candidate and setting up an interview date. ");
			System.out.println("Enter 2 for confirming or rejecting the application");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
			{
				System.out.println("select id");
				int idd= sc.nextInt();
				mac.updateStatus(idd, app.getStatus());
				System.out.println("show updated table.................");
				mac.showDetails();
				break;
			}
			case 2:
			{
				System.out.println("select id");
				int idd= sc.nextInt();
				mac.confirmationStatus(idd, app.getStatus());
				System.out.println("show updated table.................");
				mac.showDetails();
				break;
			}
		}
		if(role.equalsIgnoreCase("ADMIN"))
		{
			
			AdminService service =new AdminServiceImpl();
			int choice1 = 0;
			String p=null;
			System.out.println("Enter the operation you want to perform");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			choice = sc.nextInt();
			switch(choice1)
			{
			case 1:
			{
				System.out.println("Enter program name: ");
				prg.setProgram(sc.next());
				System.out.println("Enter program description: ");
				prg.setDescription(sc.next());		//BufferedReade)r
				System.out.println("Enter candidate eligibility: ");
				prg.setEligibility(sc.next());
				System.out.println("Enter program duration: ");
				prg.setDuration(sc.nextInt());
				System.out.println("Enter degree type: ");
				prg.setDegree(sc.next());
				
				service.addDetails(prg);	
				break;
			}
			case 2:
			{
				System.out.println("Enter the program to be deleted: ");
				p = sc.next();
				service.deleteDetails(p);
				break;
			}
			}
		}
		}
		}

}
