package com.majon.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.majon.memo.common.FileManagerService;
import com.majon.memo.post.dao.PostDAO;
import com.majon.memo.post.model.Post;

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
	
	public List<Post> getMemoList(int userId) {
		return postDAO.selectMemoList(userId);
	}
	
	public Post getMemo(int id, int userId) {
		return postDAO.selectMemo(id, userId);
	}

	public int deleteMemo(int id, int userId) {
		
		Post post = this.getMemo(id, userId);
		
		
		if(post.getImagePath() != null) {
			FileManagerService.removeFile(post.getImagePath());	
		}
		
		
		return postDAO.deleteMemo(id, userId);
	}
	
	public int updateMemo(int id, String subejct, String content, int userId) {
		return postDAO.updateMemo(id, subejct, content, userId);
	}
}
