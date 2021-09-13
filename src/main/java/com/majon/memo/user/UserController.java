package com.majon.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.majon.memo.user.bo.UserBO;

@Controller
@RequestMapping("/user")
public class UserController {
	
		@Autowired
		private UserBO userBO;

		@GetMapping("/signin_view")
		public String signinView() {
			return "user/signIn";
		}

		@GetMapping("/signup_view")
		public String signupView() {
			return "user/signUp";
		}
		
		@PostMapping("sign_up")
			public Map<String,String>signUp(
					@RequestParam("loginId")String loginId
					,@RequestParam("password") String password
					,@RequestParam("name") String name
					,@RequestParam("email") String email){
		
			int count = userBO.insertUser(loginId, password, name, email);
			
			Map<String,String> result = new HashMap<>();
			if(count==1) {
				result.put("success", "가입성공");
			}else {
				result.put("fail", "가입실패");
			}
			
			return result;
			
			}
		
		
}
