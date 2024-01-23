package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.data.User;
import com.example.demo.service.UserSearchService;

/**
 * ユーザー検索サービスクラス
 * @author suzukimasahiro
 *
 */
@Service
public class UserSearchServiceImpl implements UserSearchService{
	
	/**　DBアクセス用のクラス */
	@Autowired
	private UserDao dao;
	
	/**
	 * ユーザを全件検索するメソッド
	 * @return
	 */
	public List<User> searchAll() {
		
		/** DB検索 */
		List<Map<String, Object>> result = dao.searchAll();
		
		return getUserList(result);
	}
	
	/**
	 * ユーザを名前と性別で検索するメソッド
	 * @param name
	 * @param sex
	 * @return
	 */
	public List<User> searchUser(String name, String sex) {
		
		List<Map<String, Object>> result = dao.search(name, sex);
		return getUserList(result);
	}
	
	/**
	 * 検索結果をUserクラスのListに詰める
	 * @param result
	 * @return
	 */
	private List<User> getUserList(List<Map<String, Object>> result) {
		
		//戻り値用のリスト
		List<User> userList = new ArrayList<User>();
		
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
