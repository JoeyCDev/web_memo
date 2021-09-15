package com.majon.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.majon.memo.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	@PostMapping("/create")
	public Map<String,String> create(
			@RequestParam("subject") String subject
			,@RequestParam("content") String content
			,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postBO.addPost(userId, subject, content);
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(count==1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
}
