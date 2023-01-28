package com.itstep.htmltip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itstep.htmltip.utils.ConnectionUtil;

public class UserDao {

	public UserDao() {

	}

	public static User create(User user) {
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO tbl_admin(username,password) VALUES (?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						User newUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
						return newUser;
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static User findOne(User user) {
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "SELECT * from tbl_admin WHERE username = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				User foundUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
				return foundUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getTotal() {
		int count = 0;
		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement();) {
			String sql = "SELECT count(*) from tbl_admin";
			ResultSet rs = stmt.executeQuery(sql); 
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
