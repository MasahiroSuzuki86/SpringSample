package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
@Component
public class UserDao {
	
<<<<<<< HEAD
	 @Autowired
	  private JdbcTemplate jdbc;

	  public void testSelect() {
	    List<Map<String, Object>> list = jdbc.queryForList("SELECT * FROM user");
	    list.forEach(System.out::println);
	  }

=======
	  @Autowired
	  private JdbcTemplate jdbc;
	
	  public void method() {
		    List<Map<String, Object>> list = jdbc.queryForList("SELECT * FROM user");
		    list.forEach(System.out::println);
		  }
>>>>>>> refs/remotes/origin/main
}
