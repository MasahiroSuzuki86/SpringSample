package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Employee;
import com.example.demo.repository.EmployeeRepository;

/**
 * 従業員サービスクラス
 * @author masahiro suzuki
 *
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	/**
	 * 1件検索
	 * @param id
	 * @return
	 */
	public Employee findOne(int id) {
		
		Map<String, Object> map = empRepository.findOne(id);
		int employeeId = (Integer)map.get("employee_id");
		String employeeName = (String)map.get("employee_name");
		int age = (Integer)map.get("age");
		
		
		//検索結果をデータに詰める
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setAge(age);
		
		return employee;
		
	}

}
