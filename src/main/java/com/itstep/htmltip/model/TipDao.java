package com.itstep.htmltip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itstep.htmltip.utils.ConnectionUtil;

public class TipDao {

	public TipDao() {

	}

	public static Tip create(Tip tip) {
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO tbl_tip(title,description,exampleHtmlEscape) VALUES (?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, tip.title);
			pstmt.setString(2, tip.description);
			pstmt.setString(3, tip.exampleHtmlEscape);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						Tip newTip = new Tip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
						return newTip;
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

	public static Tip findOneById(int id) {
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "SELECT * from tbl_tip WHERE tip_id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Tip foundTip = new Tip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return foundTip;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Tip> findAll() {
		try (Connection connection = ConnectionUtil.getConnection(); Statement stmt = connection.createStatement();) {
			String sql = "SELECT * from tbl_tip";
			ResultSet rs = stmt.executeQuery(sql);

			List<Tip> tips = new ArrayList<>();

			while (rs.next()) {
				Tip tip = new Tip(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				tips.add(tip);
			}
			return tips;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.<Tip>emptyList();
	}
}
