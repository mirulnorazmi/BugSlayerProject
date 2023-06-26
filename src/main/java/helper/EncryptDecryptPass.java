package helper;

import java.util.Base64;

public class EncryptDecryptPass {
	
	public String encryptPassword (String rawPassword) {
		String encryptPassword;
		
		byte[] encrypt = Base64.getEncoder().encode(rawPassword.getBytes());
		
		encryptPassword = encrypt.toString();
		
		return encryptPassword;
	}
	
	public boolean CheckPassword (String rawPassword, String dbPassword) {
		boolean status;
		
		byte[] decrypt = Base64.getDecoder().decode(dbPassword.getBytes());
		
		if(rawPassword.equals(decrypt.toString())) {
			status = true;
		}else {
			status = false;
		}
		
		return status;
	}
}
