package dragan;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


/**
 * The <tt>HmacSha1Signature</tt> shows how to calculate 
 * a message authentication code using HMAC-SHA1 algorithm.
 *
 * <pre>
 * % java -version
 * java version "1.6.0_11"
 * % javac HmacSha1Signature.java 
 * % java -ea HmacSha1Signature
 * 104152c5bfdca07bc633eebd46199f0255c9f49d
 * </pre>
 *
 */
public class Hmac {
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	private static final String HMAC_MD5_ALGORITHM = "HmacMD5";

	private static String toHexString(byte[] bytes) {
		Formatter formatter = new Formatter();
		
		for (byte b : bytes) {
			formatter.format("%02x", b);
		}

		return formatter.toString();
		
	}

	public static String calculateHMACSHA1(String data, String key)
		throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
	{
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		return toHexString(mac.doFinal(data.getBytes()));
	}
	
	public static String calculateHMACMD5(String data, String key)
			throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
		{
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_MD5_ALGORITHM);
			Mac mac = Mac.getInstance(HMAC_MD5_ALGORITHM);
			mac.init(signingKey);
			return toHexString(mac.doFinal(data.getBytes()));
		}

	
}
