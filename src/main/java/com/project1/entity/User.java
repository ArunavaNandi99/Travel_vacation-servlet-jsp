package com.project1.entity;

public class User {

	private int id;
	
	private String username;
	private String fname;
	private String lname;
	private Long phoneNumber;
	private String email;
	private String password;

	public User() {

	}

	public User(int id, String username, String fname, String lname, Long phoneNumber, String email,
			String password) {
		super();
		this.id = id;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", fname=" + fname + ", lname=" + lname + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
