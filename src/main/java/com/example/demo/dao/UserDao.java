package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	 @Autowired
	  private JdbcTemplate jdbc;
	 
	 /**
	  * ユーザ-全件検索するメソッド
	  * @return
	  */
	 public List<Map<String, Object>>searchAll() {
		 
		 //SQL
		 String query = "SELECT * FROM user";
		 
		 //SQL実行
		 List<Map<String, Object>> list = jdbc.queryForList(query);
		 
		 
		 return list;
	 }
	 
	 /**
	  * データベース疎通確認用処理
	  */
	  public void testSelect() {
	    List<Map<String, Object>> list = jdbc.queryForList("SELECT * FROM user");
	    list.forEach(System.out::println);
	  }
}
