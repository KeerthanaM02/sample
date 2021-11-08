package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }


	public List<User> listAllUsers() {
		  String sql = "SELECT user_name,mail_id,password FROM users";
		  
		  List list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		  
		  return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(User user){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  if(user != null){
		   parameterSource.addValue("user_name", user.getUser_name());
		   parameterSource.addValue("mail_id", user.getMail_id());
		   parameterSource.addValue("password", user.getPassword());
		   
		  }
		  return parameterSource;
		 }
		 
		 private static final class UserMapper implements RowMapper{

		  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		   User user = new User();
		   user.setUser_name(rs.getString("user_name"));
		   user.setUser_name(rs.getString("mail_id"));
		   user.setUser_name(rs.getString("password"));
		   
		   return user;
		  }
		  
		 }


	public void addUser(User user) {
		String sql = "INSERT INTO users(user_name,mail_id,password)VALUES(:user_name,:mail_id,:password)";
				  
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
		
	}

	public void updateUser(User user) {
		String sql = "UPDATE users SET  mail_id = :mail_id, password = :password WHERE user_name = :user_name";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
			
	}

	public User findUserbyname(String user_name) {
		
		return null;
	}
	

}
