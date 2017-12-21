/**
 * 
 */
package com.chengmaoning.jroad.ding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Before;

/**
 * DingRobotTest.java
 * 
 * @author chengmaoning
 *
 *         2017年10月10日上午10:53:22
 */
public class DingRobotTest {
	private static final String DING_ROBOT_API = "https://oapi.dingtalk.com/robot/send?access_token=1f14f610f320baa2701403c8acfcafce92097be4641249c6c2318c6d043cffc8";
	private String json;

	@Before
	public void setUp() {
		json = "{'fincorecheck':['hello','world'],'finreconchecker':['nice',''],}";
	}

	public String readToString(String fileName) {
		String encoding = "ISO-8859-1";
		File file = new File(fileName);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}

}
