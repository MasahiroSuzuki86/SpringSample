package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginUserDao;
import com.example.demo.data.LoginUser;

/**
 * ログインユーザー検索サービスクラス
 * @author masahiro suzuki
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private LoginUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginUser user= dao.searchByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("not found :" + username);
		}
		
		return new CustomUserDetails(user);
	}
	


}
