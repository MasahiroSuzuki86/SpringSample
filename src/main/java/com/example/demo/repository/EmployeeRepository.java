package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * idから従業員テーブルを検索する処理
	 * @param id
	 * @return
	 */
	public Map<String, Object> findOne(int id) {
		
		//SQL
		String query = "SELECT "
				+ "employee_id,"
				+ "employee_name,"
				+ "age "
				+ "FROM employee "
				+ "WHERE employee_id=?";
		
		//SQL実行
		Map<String, Object> employeeMap = jdbc.queryForMap(query, id);
		
		return employeeMap;
	}
}
