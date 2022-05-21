package com.example.demo.trySpring;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//リポジトリークラスとして宣言
@Repository
public class HelloRepository {
	
	//JdbcTemplateを使う@Autowired
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> findOne(int id) {
		
		//SELECT文
		String query = "SELECT"
				+ " employee_id,"
				+ " employee_name,"
				+ " age "
				+ "FROM employee "
				+ "WHERE employee_id=?";
		
		//sqlの実行
		Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
		
		return employee;
	}
}