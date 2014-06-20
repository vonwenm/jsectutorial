//36.5.1.Generate a Blowfish key
//http://www.java2s.com/Tutorial/Java/0490__Security/GenerateaBlowfishkey.htm


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MainClass {

  public static void main(String[] args) throws Exception {

    KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
    keyGenerator.init(128);
    SecretKey key = keyGenerator.generateKey();

    Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] cipherText = cipher.doFinal("This is a test.".getBytes("UTF8"));

    System.out.println(new String(cipherText));
  }
}