package com.majon.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
			,@RequestParam("file") MultipartFile file
			,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postBO.addPost(userId, subject, content, file);
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(count==1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@GetMapping("/delete")
	public Map<String, String> delete(@RequestParam("postId") int postId
			, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		
		Map<String, String> result = new HashMap<>();
		int count = postBO.deleteMemo(postId, userId);
		
		if(count == 0) {
			result.put("result", "fail");
		} else {
			result.put("result", "success");
		}
		
		return result;
		
	}
	
	@PostMapping("/update")
	public Map<String, String> update(
			@RequestParam("postId") int postId
			, @RequestParam("subject") String subject
			, @RequestParam("content") String content
			, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> result = new HashMap<>();
		
		int count = postBO.updateMemo(postId, subject, content, userId);
		
		if(count == 0) {
			result.put("result", "fail");
		} else {
			result.put("result", "success");
		}
		
		return result;
		
	}
	
}
