package com.majon.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {

	public final static String FILE_UPLOAD_PATH = "D:\\Dev_Joey\\springTest\\upload\\images/";
	
	public static String saveFile(int userId, MultipartFile file) {
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		//"D:\\Dev_Joey\\springTest\\upload\\images/43_281281298129/
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 디렉토리 생성
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			return null;
		}
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return "/images/" + directoryName + file.getOriginalFilename();
		
	}
	
	public static void removeFile(String filePath) {
		// filePath
		// post테이블에 있는 imagePath
		// ex > /images/1-201020123/test.png
		// 실제 경로 ex > "D:\\Dev_Joey\\springTest\\upload\\images\1-201020123\test.png
		
		String realFilePath = FILE_UPLOAD_PATH + filePath.replace("/images/", "");
		Path path = Paths.get(realFilePath);
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		// 디렉토리(폴더) 삭제
		// "D:\\Dev_Joey\\springTest\\upload\\images\1-201020123
		path = path.getParent();
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}