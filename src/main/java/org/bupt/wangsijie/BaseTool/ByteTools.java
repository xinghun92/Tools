package org.bupt.wangsijie.BaseTool;

/**
 * 
 * Copyright © 2016 王思杰. All rights reserved.
 *
 * 
 * 
 * @Title: ByteTools.java
 * 
 * @Prject: Tools
 * 
 * @Package: org.bupt.wangsijie.BaseTool
 * 
 * @Description: Byte相关操作
 * 
 * @author: 王思杰
 * 
 * @date: 2016年8月8日 下午8:43:58
 * 
 * @version: V1.0
 * 
 */
public class ByteTools {
	/**
	 * bytesToHexString(将byte数组转化为十六进制String串)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param bytes 输入byte数组
	 * @return
	 *String 转化成的十六进制字符串
	 * @exception
	 * @since  1.0.0
	*/
	public static String bytesToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		if (bytes == null || bytes.length <= 0) {
			return "";
		}
		for (int i = 0; i < bytes.length; i++) {
			int bin = bytes[i] & 0xFF;
			String hex = Integer.toHexString(bin);
			if (hex.length() < 2) {
				sb.append(0);
			}
			sb.append(hex);
		}
		return sb.toString();
	}

	/**
	 * hexStringToBytes(将十六进制字符串转化为byte数组)
	 * (十六进制字符串长度必须是偶数)
	 * @param hexString 十六进制字符串
	 * @return
	 *byte[] byte数组
	 * @exception
	 * @since  1.0.0
	*/
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			int index = i * 2;
			bytes[i] = (byte) (charToByte(hexChars[index]) << 4 | charToByte(hexChars[index + 1]));
		}
		return bytes;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
}
