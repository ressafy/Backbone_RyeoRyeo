package member.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class OpenCrypt {
	// 여기 byte[]가 해쉬값인데 어떻게 저장할까를 고민
	// 해슁은 복호화가 안된다. 암호화만 있는 것이다. 
	// 회원가입할 때 중요한 정보를 받아서 그것을 암복호화가 가능한  aes 알고리즘을 적용
	 public static byte[] getSHA256(String source, String salt) {
				// source 가 비밀번호
           byte byteData[]=null;
           try{
               MessageDigest md = MessageDigest.getInstance("SHA-256"); 
               md.update(source.getBytes()); 
               md.update(salt.getBytes()); 
               byteData= md.digest();  // 이게 해쉬값이다.
               System.out.println("원문: "+source+ "   SHA-256: "+
                                     byteData.length+","+byteArrayToHex(byteData));
           }catch(NoSuchAlgorithmException e){
               e.printStackTrace(); 
           }
           return byteData;
     }
	 	 // aes 에 쓸 key
	  public static byte[] generateKey(String algorithm,int keySize) throws NoSuchAlgorithmException {
		 
	       KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);	 
	       keyGenerator.init(keySize);
	       SecretKey key = keyGenerator.generateKey();
	       return key.getEncoded();	 
}	

// 회원가입할 때 쓸 암복호화 가능한 aes 
// key 가 암호화 키이다. 
 public static String aesEncrypt(String msg, byte[] key) throws Exception {
       SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        String iv = "AAAAAAAAAAAAAAAA";
        cipher.init(Cipher.ENCRYPT_MODE, 
        		       skeySpec,
        		       new IvParameterSpec(iv.getBytes()));        
        byte[] encrypted = cipher.doFinal(msg.getBytes());     
        return  byteArrayToHex(encrypted);
 }
	 
public static String aesDecrypt(String msg,byte[] key ) throws Exception {
 	        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        String iv = "AAAAAAAAAAAAAAAA";
	        cipher.init(Cipher.DECRYPT_MODE, 
	        		       skeySpec,
	        		       new IvParameterSpec(iv.getBytes()));  
	        byte[] encrypted = hexToByteArray(msg);
	        byte[] original = cipher.doFinal(encrypted);  
	        return new String(original); 
}
	 // hex 를 byte array 로… 복호화된게 기니까    저장할 땐 hex 로 쓸 땐 byte로
	 public static byte[] hexToByteArray(String hex) {
		    if (hex == null || hex.length() == 0) {
		        return null;
		    }
		 
		    byte[] ba = new byte[hex.length() / 2];
		    for (int i = 0; i < ba.length; i++) {
		        ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		    }
		    return ba;
		}
		 
		// byte[] to hex
		public static String byteArrayToHex(byte[] ba) {
		    if (ba == null || ba.length == 0) {
		        return null;
		    }
		 
		    StringBuffer sb = new StringBuffer(ba.length * 2);
		    String hexNumber;
		    for (int x = 0; x < ba.length; x++) {
		        hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
		 
		        sb.append(hexNumber.substring(hexNumber.length() - 2));
		    }
		    return sb.toString();
		} 
	 
}
