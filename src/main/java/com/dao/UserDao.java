package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertUser(UserBean user) {
		stmt.update("insert into users (firstname,lastname,email,password) values (?,?,?,?)", user.getFirstName(),
				user.getLastName(), user.getEmail(), user.getPassword());
	}

	public List<UserBean> getAllUsers() {
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid = ?", userId);
	}

	public UserBean getUserByUserId(int userId) {
		UserBean user = stmt.queryForObject("select * from users where userId = ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });
		return user;

	}

	public void updateUser(UserBean user) {

		stmt.update("update users set firstname = ?, lastname=? , email = ? , password = ?  where userid = ? ", user.getFirstName(),
				user.getLastName(),user.getEmail(),user.getPassword(),user.getUserId());

	}

	public List<UserBean> getUserByName(String search) {
		
		List<UserBean> users = stmt.query("select * from users where firstname like ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { search });
		return users;
		
	}

	public UserBean getByEmail(String email) {
		
		try {
			return stmt.queryForObject("select * from users where email=? ", new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] {email});
		}
		catch (Exception e) {
			System.out.println("User Not Found with => "+email);
			return null;
		}
	}
	
	
	public void updateToken(int userId, String token) {
		stmt.update("update users set token = ? where userid = ? ", token, userId);
	}
	
	public boolean isValidToken(String token) {
		List<UserBean> users = stmt.query("select * from users where token  = ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { token });
		if (users.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	

}
