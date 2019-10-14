package com.uas.beans;

public class Login {
	String user,pass,role;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginPage [user=" + user + ", pass=" + pass + ", role=" + role + "]";
	}
	public Login() {

		this.user = " ";
		this.pass = " " ;
		this.role = " ";
	}

	public Login(String user, String pass) {

		this.user = user;
		this.pass = pass;

	}

}
