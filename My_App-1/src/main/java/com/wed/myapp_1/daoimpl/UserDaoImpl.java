package com.wed.myapp_1.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wed.myapp_1.common.User;
import com.wed.myapp_1.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String UPDATE_USER ="update user set dob=:dob, email_id=:email, first_name=:fName, last_name=:lName, mobile_no=:mNo, password=:password where user_id=:id";
	private String GET_USERID ="Select * from user where user_id = ?";
	
	@Override
	public User updateUser(User user, int id) {
		MapSqlParameterSource mps = new MapSqlParameterSource();
		mps.addValue("dob", user.getDob());
		mps.addValue("email", user.getEmailId());
		mps.addValue("fName", user.getFirstName());
		mps.addValue("lName", user.getLastName());
		mps.addValue("mNo", user.getMobileNo());
		mps.addValue("password", user.getPassword());
		mps.addValue("id", id);
		namedParameterJdbcTemplate.update(UPDATE_USER, mps);
		return user;
	}

	@Override
	public User getUserById(int id) {
		
		return jdbcTemplate.queryForObject(GET_USERID, new BeanPropertyRowMapper<>(User.class), id);
	}

}
