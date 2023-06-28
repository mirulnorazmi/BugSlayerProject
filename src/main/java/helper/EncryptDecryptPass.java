package helper;

import java.util.Base64;

public class EncryptDecryptPass {
	
	public String encryptPassword (String rawPassword) {
		String encryptPassword;
		Base64.Encoder encoder = Base64.getMimeEncoder();  
		
//		byte[] encrypt = Base64.getEncoder().encode(rawPassword.getBytes());
		encryptPassword= encoder.encodeToString(rawPassword.getBytes());  
//		encryptPassword = encrypt.toString();
		System.out.println(encryptPassword);
		return encryptPassword;
	}
	
	public String decryptPassword (String dbPassword) {
//		String decryptPassword;
		Base64.Decoder decoder = Base64.getMimeDecoder();  
		String decryptPassword = new String(decoder.decode(dbPassword));  

		
		return decryptPassword;
	}
	
	public boolean CheckPassword (String rawPassword, String dbPassword) {
		boolean status = false;
		Base64.Decoder decoder = Base64.getMimeDecoder();  
//		byte[] decrypt = Base64.getDecoder().decode(dbPassword.getBytes());
//		String dStr = new String(decoder.decode(dbPassword));  
		
		if(rawPassword.equals(decryptPassword(dbPassword))) {
			status = true;
			System.out.println("status : " + status);
		}else {
			status = false;
		}
		
		return status;
	}
}
