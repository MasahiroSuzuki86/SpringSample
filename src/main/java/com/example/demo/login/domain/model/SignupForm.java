package com.example.demo.login.domain.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import  org.hibernate.validator.constraints.Length;

@Data
public class SignupForm {
	//必須入力、メールアドレス形式
	@NotBlank
	@Email
	private String userId; //ユーザーID
	
	//必須入力、長さ4から100桁まで、半角英数字のみ
	@NotBlank
	@Length(min=4, max=100)
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;//パスワード
	
	//必須入力
	@NotBlank
	private String userName;//ユーザー名
	
	//必須入力
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	
	//値が20から100まで
	@Min(20)
	@Max(100)
	private int age;//年齢
	
	//falseのみ可能
	@AssertFalse
	private boolean marriage;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarriage() {
		return marriage;
	}
	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}
}
