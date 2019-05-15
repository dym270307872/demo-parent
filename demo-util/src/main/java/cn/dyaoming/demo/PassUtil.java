package cn.dyaoming.demo;


import cn.dyaoming.utils.Md5Util;


public class PassUtil {

	/**
	 * 功能描述：计算语法。
	 *
	 * @param s String类型 需要加密的字符串
	 * @param icv String类型 验值字符串
	 * @return String类型 加密后字符串（结果会转换成大写）
	 */
	public final static String icvMd5(String s, String icv) {
		return Md5Util.md5(s.toLowerCase() + Md5Util.md5(icv).toUpperCase()).toUpperCase();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String password = "123456";
		String salt = "abcdefg";
		System.out.println("MD5:	" + Md5Util.md5(password));
		System.out.println("MD5_toupper:	" + Md5Util.md5(password).toUpperCase());
		System.out.println("MD5_tolower:	" + Md5Util.md5(password).toLowerCase());

		System.out.println("new_pass:	" + icvMd5(Md5Util.md5(password).toUpperCase(), salt));

		/*
		 * 测试用例A
		 * MD5: e10adc3949ba59abbe56e057f20f883e
		 * MD5_toupper: E10ADC3949BA59ABBE56E057F20F883E
		 * MD5_tolower: e10adc3949ba59abbe56e057f20f883e
		 * new_pass: 5773a17ab25a360e952408da73d315c8
		 * 测试用例B
		 * MD5: e10adc3949ba59abbe56e057f20f883e
		 * MD5_toupper: E10ADC3949BA59ABBE56E057F20F883E
		 * MD5_tolower: e10adc3949ba59abbe56e057f20f883e
		 * new_pass: 5773A17AB25A360E952408DA73D315C8
		 */
	}

}
