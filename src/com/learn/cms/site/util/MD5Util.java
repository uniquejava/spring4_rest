package com.learn.cms.site.util;

import java.security.MessageDigest;

public class MD5Util {
	/**
	 * MD5 generate 32 chars.
	 * 
	 * @param inStr
	 * @return
	 */
	public static String md5Encode(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] byteArray = inStr.getBytes("UTF-8");
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		String str = new String("admin");
		System.out.println("be4：" + str);
		System.out.println("MD5：" + md5Encode(str));
	}
}