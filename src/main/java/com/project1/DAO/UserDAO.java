package com.project1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.project1.entity.User;

public class UserDAO {
	private Connection con;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean registerUser(User user) {

		boolean f = false;

		try {
			String sql = "insert into user(username,fname,lname,email,password) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFname());
			ps.setString(3, user.getLname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(User user) {

		User user2 = null;

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select * from user where username=? and password=?  ";
			ps = con.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			rs = ps.executeQuery();

			if (rs.next()) {
				user2 = new User();
				user2.setId(rs.getInt("id"));
				user2.setUsername(rs.getString("username"));
				user2.setFname(rs.getString("fname"));
				user2.setLname(rs.getString("lname"));
				user2.setEmail(rs.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return user2;
	}

}
