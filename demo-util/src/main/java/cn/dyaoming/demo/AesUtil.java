//package cn.dyaoming.demo;
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import cn.dyaoming.utils.Base64Util;
//
//public class AesUtil
//{
//		
//	public static byte[] encrypt(String encryptString, String encryptKey)
//	{
//		try
//		{
//				if (encryptKey == null)
//				{
//					System.out.print("Key为空null");
//					return null;
//				}
//		
//				// 判断Key是否为16位
//				if (encryptKey.length() != 16)
//				{
//					System.out.print("Key长度不是16位");
//					return null;
//				}
//		
//				byte[] raw = encryptKey.getBytes("UTF-8");
//				SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//				// "算法/模式/补码方式"
//				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//				// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
//				IvParameterSpec iv = new IvParameterSpec(encryptKey.getBytes("UTF-8"));
//				cipher.init(Cipher.ENCRYPT_MODE, skeySpec,iv);
//				byte[] encrypted = cipher.doFinal(encryptString.getBytes("UTF-8"));
//		
//				// 此处不使用BASE64做转码功能。
//				return encrypted;
//				
//		}catch (Exception e)
//		{
//			System.out.println(e.toString());
//			e.printStackTrace();
//			
//			return null;
//		}
//		
//	}
//	
//	public static byte[] decrypt(byte[] decryptString, String decryptKey)
//	{
//		try
//		{
//			//判断Key是否正确
//			if (decryptKey == null)
//			{
//				System.out.print("Key为空null");
//				return null;
//			}
//
//			// 判断Key是否为16位
//			if (decryptKey.length() != 16)
//			{
//				System.out.print("Key长度不是16位");
//				return null;
//			}
//			
//			//byte[] raw = decryptKey.getBytes("ASCII");
//			byte[] raw = decryptKey.getBytes("UTF-8");
//			
//			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//			IvParameterSpec iv = new IvParameterSpec(decryptKey.getBytes("UTF-8"));
//			cipher.init(Cipher.DECRYPT_MODE, skeySpec,iv);
//
//			try
//			{
//				byte[] original = cipher.doFinal(decryptString);
//				return original;
//
//			} catch (Exception e)
//			{
//				System.out.println(e.toString());
//				return null;
//			}
//		} catch (Exception e)
//		{
//			System.out.println(e.toString());
//			e.printStackTrace();
//			
//			return null;
//		}
//	}
//	
//	
//	
//	public static void main(String[] args) throws Exception
//	{
//	
//		String text = "逻辑傲世狂妃那是的基本法师的立法是肯定没法拉斯";
//		
//		System.out.println(Base64Util.encryptBASE64(encrypt(text,"1234567812345678")));
//		
////		String key = "PHQaDyxfTdutEYdE";
//		String key = "eAMegubCLhcZstpS";
//		String mi = "qGHJG/bTfjKFFt7K8f0tXKVmme4EotShgtyfBo0GfYQ=";
//
////		String ming = "username=15821982729&validcode=5558";
////		String pa = "xzqh=&grbh=&sfzh=419003195710021559&xm=王彦云&sbkh=&szlb=购药&bdsj=2013-11-24 10:19:47&jylsh=201311241019476147&pagenum=1&pagesize=10";
//
////		System.out.println(pa);
////		String param =Base64Util.encryptBASE64(encrypt(pa,key)).replace("\r\n", "");
////		System.out.println(param);
////		System.out.println(new String(decrypt(Base64Util.decryptBASE64(pa.replace("\r\n", "")),key), "utf-8"));
//		byte[] arr_mw_64 = Base64Util.decryptBASE64(mi);
//		
//		byte[] arr_mw_jm = AesUtil.decrypt(arr_mw_64,key);
//
//		System.out.println(new String(arr_mw_jm, "utf-8"));
//		
//		
//		
//	}
//	
//	
//	
//
//}
