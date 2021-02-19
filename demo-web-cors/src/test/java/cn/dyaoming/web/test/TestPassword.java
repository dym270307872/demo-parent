package cn.dyaoming.web.test;

import org.apache.tomcat.util.security.MD5Encoder;

import cn.dyaoming.utils.HashUtil;
import cn.dyaoming.utils.Md5Util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class TestPassword {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String passwordString = securite("myPassword");

		System.out.println(passwordString);
	}

	public static String securite(String password) throws Exception {
		String salt = SaltGenerate(64);
		System.out.println(salt);
		String encryPasswordString = HashUtil.md5Encode(password);
		System.out.println(encryPasswordString);
		String resultPasswordString = HashUtil.sha256Encode(encryPasswordString.toUpperCase() + salt);
		System.out.println(resultPasswordString);
		return resultPasswordString;
	}
	
	
	public static String byteArrayToHexString(byte[] bytes) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xff & bytes[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	public static String SaltGenerate(int length) {
		Random ranGen = new SecureRandom();
		byte[] aesKey = new byte[length/2];
		ranGen.nextBytes(aesKey);
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < aesKey.length; i++) {
			String hex = Integer.toHexString(0xff & aesKey[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

}
