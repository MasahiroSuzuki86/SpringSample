package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.data.User;

/**
 * ユーザー検索サービスクラス
 * @author suzukimasahiro
 *
 */
@Service
public class UserSearchService {
	
	@Autowired
	private UserDao dao;
	
	public List<User> searchAll() {
		
		List<User> userList = new ArrayList<User>();
		
		List<Map<String, Object>> result = dao.searchAll();
		for(int i = 0; i < result.size(); i++) {
			int id = (Integer)result.get(i).get("id");
			String name = (String)result.get(i).get("name");
			String sex = (String)result.get(i).get("sex");
			String address = (String)result.get(i).get("address");
			String age = (String)result.get(i).get("age");
			String birthday = (String)result.get(i).get("birthday");
			String role = (String)result.get(i).get("role");
			
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setSex(sex);
			user.setAddress(address);
			user.setAge(age);
			user.setBirthday(birthday);
			user.setRole(role);
			userList.add(user);
		}
		
		return userList;
	}

}
