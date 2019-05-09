/**
 * 
 */
package com.chengmaoning.jroad.token;

import java.net.URLEncoder;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * TokenTest.java
 * 
 * @author chengmaoning
 *
 *         2019年5月9日上午10:47:50
 */
public class TokenTest {

	@Test
	public void test() {
		String token = "54cc8224a92ddda750600157e17b33c8";
		String signature = getSignature(token);
		System.out.println("signature = " + signature);
	}

	/**
	 * 生成签名 signature
	 * 
	 * @param token
	 * @return
	 */
	public String getSignature(String token) {
		Assert.hasText(token, "token can not have no text!");
		Date date = new Date();
		long time = date.getTime();
		System.out.println("time = " + time);
		String signature = HMACSHA256(String.valueOf(time).getBytes(), token.getBytes());
		return signature;
	}

	/**
	 * SHA256 加密工具类
	 * 
	 * @param date
	 * @param key
	 * @return
	 */
	public static String HMACSHA256(byte[] date, byte[] key) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);

			return URLEncoder.encode(byte2Base64(mac.doFinal(date)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Base64编码
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byte2Base64(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

}
