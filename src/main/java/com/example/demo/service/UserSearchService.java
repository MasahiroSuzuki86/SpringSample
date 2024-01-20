package com.example.demo.service;

import java.util.List;

import com.example.demo.data.User;

/**
 * ユーザー検索サービスクラス
 * @author suzukimasahiro
 *
 */
public interface UserSearchService {
	
	/**
	 * ユーザを全件検索するメソッド
	 * @return
	 */
	public List<User> searchAll();
	
	/**
	 * ユーザを名前と性別で検索するメソッド
	 * @param name
	 * @param sex
	 * @return
	 */
	public List<User> searchUser(String name, String sex);

}
