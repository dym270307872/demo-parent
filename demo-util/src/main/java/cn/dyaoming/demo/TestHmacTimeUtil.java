package cn.dyaoming.demo;

import java.security.SecureRandom;
import java.util.Random;

import cn.dyaoming.utils.HashUtil;
import cn.dyaoming.utils.HmacUtil;

public class TestHmacTimeUtil {

	public static String saltGenerate(int length) {
		Random ranGen = new SecureRandom();
		byte[] aesKey = new byte[length / 2];
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

	public static void main(String[] args) {
//		String messageString = "myPassword";
//		String keyString = saltGenerate(64);
//		String message = HashUtil.md5Encode(messageString);

		String message = "deb1536f480475f7d593219aa1afd74c";
		String keyString = "e1487853580b078fefbedd69405f9e8943ace7851b51d16a8e3102ed4157ee30";
//		System.out.println(message);
//		System.out.println(keyString);
		
		
//		// hash测试
//		long startTime2 = System.currentTimeMillis();
////		for (int i = 0; i < 1000; i++) {
		System.out.println(HashUtil.sha256Encode(message + keyString));
////		}
//		long endTime2 = System.currentTimeMillis();
//		System.out.println("hash:" + (endTime2 - startTime2));
//		// hmac测试
//		long startTime = System.currentTimeMillis();
////				for (int i = 0; i < 1000; i++) {
		System.out.println(HmacUtil.sha256(message, keyString));
////				}
//		long endTime = System.currentTimeMillis();
//		System.out.println("hmac:" + (endTime - startTime));

	}

}
