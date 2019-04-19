package com.novellius.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();

		admin.setIdAd(rs.getInt("IdAd"));
		admin.setNameAd(rs.getString("nameAd"));
		admin.setWorkPositionAd(rs.getString("workPositionAd"));
		admin.setCreation_date(rs.getTimestamp("creation_date"));

		return admin;
	}

}
