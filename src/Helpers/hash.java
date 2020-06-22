package Helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
	
	public String TEST;
	
	public hash(String pass) throws NoSuchAlgorithmException {	
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0;i<digest.length;i++) {
        hexString.append(Integer.toHexString(0xFF & digest[i]));
      }
        TEST=hexString.toString();
        System.out.println(TEST);
	}
	
	public String getTEST() {
		return TEST;
	}

	public void setTEST(String TEST) {
		this.TEST = TEST;
	}

}

