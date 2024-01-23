package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.data.LoginUser;

@Component
public class LoginUserDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * ユーザ検索するメソッド
	 * @param userName
	 * @return
	 */
	public LoginUser searchByUserName(String userName) {
		
		String query = "SELECT * FROM login_user WHERE user_name like ?";
		
		//SQL実行
		List<Map<String, Object>> list = jdbc.queryForList(query, userName);
		
		return getLoginUser(list);
	}
	
	/**
	 * 検索結果をLoginUserクラスに詰める
	 * @param result
	 * @return
	 */
	private LoginUser getLoginUser(List<Map<String, Object>> result) {
		
		LoginUser loginUser = new LoginUser();
		
		for(int i = 0; i < result.size(); i++) {
			int id = (Integer)result.get(i).get("id");
			String userName = (String)result.get(i).get("user_name");
			String password = (String)result.get(i).get("password");
			String email = (String)result.get(i).get("email");
			
			loginUser.setId(id);
			loginUser.setEmail(userName);
			loginUser.setPassword(password);
			loginUser.setEmail(email);
		}
		
		return loginUser;
	}
}
