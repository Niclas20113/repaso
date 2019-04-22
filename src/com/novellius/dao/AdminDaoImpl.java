package com.novellius.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import com.novellius.pojo.Admin;
import com.novellius.pojo.AdminRowMapper;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean saveAd(Admin admin) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"Insert into springbd.admin (nameAd,workPositionAd,creation_date)values(:nameAd,:workPositionAd,:creation_date)",
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	@Override
	public List<Admin> findAllAd() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("Select * from springbd.admin", new AdminRowMapper());
	}

	@Override
	public Admin findByIdAd(int idAd) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("Select * from springbd.admin where IdAd=:IdAd",
				new MapSqlParameterSource("IdAd", idAd), new AdminRowMapper());
	}

	@Override
	public List<Admin> findByNameAd(String nameAd) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("Select * from springbd.admin where nameAd like :nameAd",
				new MapSqlParameterSource("nameAd", nameAd + "%"), new AdminRowMapper());
	}

	@Override
	public boolean updateAd(Admin Admin) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"Update springbd.admin set nameAd=:nameAd, workPositionAd=:workPositionAd where IdAd=:IdAd",
				new BeanPropertySqlParameterSource(Admin)) == 1;
	}

	@Override
	public boolean deleteAd(int idAd) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("Delete from springbd.admin where IdAd=:IdAd",
				new MapSqlParameterSource("IdAd", idAd)) == 1;
	}

	@Override
	public int[] saveAllAd(List<Admin> saveAdmins) {
		// TODO Auto-generated method stub
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(saveAdmins.toArray());
		return jdbcTemplate.batchUpdate(
				"Insert into springbd.admin (nameAd,workPositionAd,creation_date)values(:nameAd,:workPositionAd,:creation_date)",
				batchArgs);
	}

}
