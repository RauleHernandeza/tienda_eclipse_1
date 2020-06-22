package Helpers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash2 {
	
	public String TEST;
	
        
	public hash2(String TEST) throws NoSuchAlgorithmException {	
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(TEST.getBytes(StandardCharsets.UTF_8));
		setTEST(bytesToHex(encodedhash));
	}
	
	public String getTEST() {
		return TEST;
	}

	public void setTEST(String TEST) {
		this.TEST = TEST;
                System.out.println(TEST);
	}

	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
        
        
}
