package com.majon.memo.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.majon.memo.common.FileManagerService;
import com.majon.memo.post.dao.PostDAO;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	
	public int addPost(int userId, String subject, String content, MultipartFile file) {
		
		String imagePath = null;
		if(file != null) {
		imagePath = FileManagerService.saveFile(userId, file);
		if(imagePath == null) {
			return 0;
		}
		}
		
		return postDAO.insertPost(userId, subject, content, imagePath);
	}
	
}