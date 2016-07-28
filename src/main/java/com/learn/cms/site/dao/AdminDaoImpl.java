package com.learn.cms.site.dao;

import com.learn.cms.site.model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminDaoImpl implements AdminDao {
	private final Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Admin> findAll() {
		List<Admin> result = jdbcTemplate.query("select * from admin", new Object[] {},
				new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
						Admin admin = new Admin();
						admin.setId(rs.getLong("id"));
						admin.setAdminUser(rs.getString("admin_user"));
						admin.setAdminPwd(rs.getString("admin_pwd"));
						return admin;
					}
				});

		return result;
	}

	public Admin findById(Long id) {
		String sql = "select * from admin where id=?";

		List<Object> params = new ArrayList<Object>();
		params.add(id);

		logger.debug(sql);
		logger.debug(params.toString());

		Admin result = jdbcTemplate.queryForObject(sql, params.toArray(), new RowMapper<Admin>() {

			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				admin.setId(rs.getLong("id"));
				admin.setAdminUser(rs.getString("admin_user"));
				admin.setAdminPwd(rs.getString("admin_pwd"));
				return admin;
			}
		});

		return result;
	}
}
