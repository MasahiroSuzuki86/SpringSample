package com.example.demo.data;

import lombok.Data;

@Data
public class User {
	
	//ユーザ番号
	private int id;
	
	//ユーザー名
	private String name;
	
	//性別
	private String sex;
	
	//住所
	private String address;
	
	//年齢
	private String age;
	
	//生年月日
	private String birthday;
	
	//権限
	private String role;
}
