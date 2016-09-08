package org.bupt.wangsijie.test.BaseTool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.bupt.wangsijie.base.ByteTools;
import org.junit.Test;

/**  

 * Copyright © 2016 王思杰. All rights reserved.

 *

 * @Title: ByteToolTest.java

 * @Prject: Tools

 * @Package: org.bupt.wangsijie.test.BaseTool

 * @Description: TODO

 * @author: 王思杰  

 * @date: 2016年8月8日 下午8:57:06

 * @version: V1.0  

 */
public class ByteToolTest {
	
	@Test
	public void testBin2Hex(){
		byte[] bytes = new byte[64];
		BufferedInputStream is;
		
		try {
			is = new BufferedInputStream(new FileInputStream(new File("Data_1")));
			int length;
			while ((length = is.read(bytes)) != -1) {
				byte[] data = new byte[length];
				data = Arrays.copyOf(bytes, length);
//				System.out.println(ByteTools.bytesToHexString(data));
				for (int i = 0; i < data.length; i++) {
					System.out.print(data[i]);
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHex2Bin(){
		String hexString = "f8f90fff2400feff0000";
		byte[] bytes = ByteTools.hexStringToBytes(hexString);
		for (int i = 0; i < bytes.length; i++) {
			System.out.println(Integer.toHexString(bytes[i] & 0xff));
		}
	}
}
