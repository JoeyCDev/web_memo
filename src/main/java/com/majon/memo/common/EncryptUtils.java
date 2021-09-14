package com.majon.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	
	// 암호화 메소드
	public static String md5(String message) {
		
		String encData = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 1byte = 8bit = 10101011
			// asdf -> a = 64 = 1000000
			// [1000000, 1010100, 1000101, 1010111]
			byte[] bytes = message.getBytes();
			md.update(bytes);
			
			byte[] digest = md.digest();
			// byte -> 16진수 -> 문자열
			for(int i=0; i< digest.length; i++) {
				// 67abe
				encData += Integer.toHexString(digest[i] & 0xff);
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encData;
	}
	
}
