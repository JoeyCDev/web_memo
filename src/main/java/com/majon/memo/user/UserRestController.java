package com.majon.memo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.majon.memo.model.User;
import com.majon.memo.user.bo.UserBO;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	@PostMapping("sign_up")
	@ResponseBody
	public Map<String,String>signUp(
			@RequestParam("loginId")String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email){

		int count = userBO.insertUser(loginId, password, name, email);
		
		Map<String,String> result = new HashMap<>();
		if(count==1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	
		}
	
	@PostMapping("/sign_in")
	@ResponseBody
	public Map<String,String> signIn(
			@RequestParam("loginId") String id
			,@RequestParam("password") String password
			, HttpServletRequest request){
		
		User user = userBO.getUser(id, password);
		
		Map<String,String>resultMap = new HashMap<>();
		
		// 셀렉트 결과가 있냐 없냐?
		// 셀렉트 결과가 있다
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		
	}
	
}
