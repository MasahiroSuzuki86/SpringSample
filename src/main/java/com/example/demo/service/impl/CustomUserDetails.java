package com.example.demo.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.data.LoginUser;

@Service
public class CustomUserDetails implements UserDetails {
	
	private final LoginUser user;
	
	/**
	 * コンストラクタ
	 * @param user
	 */
	public CustomUserDetails(LoginUser user) {
		this.user = user;
	}
	
	/**
	 * ロールの取得
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	/**
	 * パスワードの取得
	 */
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	/**
	 * ユーザー名の取得
	 */
	@Override
	public String getUsername() {
		return this.user.getUserName();
	}
	
	/**
	 * アカウントが有効期限でないか
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/**
	 * アカウントがロックされていないか
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	/**
	 * 認証情報が有効期限切れでないか
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	/**
	 * アカウントが有効であるかどうか
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
