package cn.dyaoming.web.test;

import java.security.SecureRandom;
import java.util.Arrays;

import cn.dyaoming.utils.SerializeUtil;

public class TestObjectUtil {

	public static void main(String[] args) {
		byte[] bytes = new byte[16];
		new SecureRandom().nextBytes(bytes);;
		Object obj = bytes;
		
		System.out.println(obj);
		if(obj instanceof byte[]) {
			byte[] aa = (byte[])obj;
			System.out.println(Arrays.equals(bytes, aa));
		}
		byte[] bb = SerializeUtil.serialize(obj);
		
		System.out.println(Arrays.equals(bytes, bb));
		
		
	}

}
