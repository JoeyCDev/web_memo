package com.majon.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majon.memo.common.EncryptUtils;
import com.majon.memo.model.User;
import com.majon.memo.user.dao.UserDAO;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	public int insertUser(String loginId, String password, String name, String email) {
		// password 암호화
		
		String encryptPassword = EncryptUtils.md5(password);
		
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	public User getUser(String login, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.selectUserByLoginIdPassword(login, encryptPassword);
		
	}
	
}
