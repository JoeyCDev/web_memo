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

		@GetMapping("/signin_view")
		public String signinView() {
			return "user/signIn";
		}

		@GetMapping("/signup_view")
		public String signupView() {
			return "user/signUp";
		}
		
		
}
