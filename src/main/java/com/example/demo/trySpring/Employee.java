package com.example.demo.trySpring;
import lombok.Data;

//@Dataでlombokのセッターゲッターが自動で作られる
@Data
public class Employee {
	
	private int employeeId;
	private String employeeName;
	private int age;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}