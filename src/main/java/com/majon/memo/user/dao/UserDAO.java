package com.majon.memo.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.majon.memo.model.User;

@Repository	
public interface UserDAO {

	public int insertUser(
			@Param("loginId")String loginId, 
			@Param("password")String password, 
			@Param("name")String name, 
			@Param("email")String email);
	
	public User selectUserByLoginIdPassword(
			@Param("loginId") String loginId
			,@Param("password") String password
			);
	
	
}
