package com.learn.cms.site.dao;

import com.learn.cms.site.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MsgDaoImpl implements MsgDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Msg> findAll() {
		List<Msg> result = jdbcTemplate.query("select * from msg", new Object[] {}, new RowMapper<Msg>() {
			public Msg mapRow(ResultSet rs, int rowNum) throws SQLException {
				Msg o = new Msg();
				o.setId(rs.getLong("id"));
				o.setName(rs.getString("name"));
				o.setContent(rs.getString("content"));
				o.setPhone(rs.getString("phone"));
				o.setQq(rs.getString("qq"));
				o.setIp(rs.getString("ip"));
				o.setStatus(rs.getInt("status"));
				o.setCreateTime(rs.getDate("create_time"));
				return o;
			}
		});

		return result;
	}

	public Msg findById(Long id) {
		String sql = "select * from msg where id=?";
		Msg result = jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Msg>() {

			public Msg mapRow(ResultSet rs, int rowNum) throws SQLException {
				Msg o = new Msg();
				o.setId(rs.getLong("id"));
				o.setName(rs.getString("name"));
				o.setContent(rs.getString("content"));
				o.setPhone(rs.getString("phone"));
				o.setQq(rs.getString("qq"));
				o.setIp(rs.getString("ip"));
				o.setStatus(rs.getInt("status"));
				o.setCreateTime(rs.getDate("create_time"));
				return o;
			}
		});

		return result;
	}

	public void saveMsg(Msg msg) {
		String sql = "insert into msg(name,content,phone,qq,ip,status,create_time) values(?,?,?,?,?,?, now())";

		List<Object> params = new ArrayList<Object>();
		params.add(msg.getName());
		params.add(msg.getContent());
		params.add(msg.getPhone());
		params.add(msg.getQq());
		params.add(msg.getIp());
		params.add(msg.getStatus());

		jdbcTemplate.update(sql, params.toArray());

	}

	public void updateMsg(Msg msg) {
		String sql = "update msg set name=?,content=?,phone=?,qq=?,ip=?,status=? where id=?";

		List<Object> params = new ArrayList<Object>();
		params.add(msg.getName());
		params.add(msg.getContent());
		params.add(msg.getPhone());
		params.add(msg.getQq());
		params.add(msg.getIp());
		params.add(msg.getStatus());
		params.add(msg.getId());

		jdbcTemplate.update(sql, params.toArray());
	}

	public void deleteById(Long id) {
		jdbcTemplate.update("delete from msg where id=?", id);

	}

}
