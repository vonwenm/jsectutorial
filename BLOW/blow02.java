//36.5.2.Create a Blowfish key, encrypts some text,prints the ciphertext, then decrypts the text
//http://www.java2s.com/Tutorial/Java/0490__Security/CreateaBlowfishkeyencryptssometextprintstheciphertextthendecryptsthetext.htm



import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class MainClass {
  public static void main(String[] args) throws Exception {
    String text = "java2s";

    KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
    keyGenerator.init(128);

    Key key = keyGenerator.generateKey();

    Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] ciphertext = cipher.doFinal(text.getBytes("UTF8"));

    for (int i = 0; i < ciphertext.length; i++) {
      System.out.print(ciphertext[i] + " ");
    }
    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedText = cipher.doFinal(ciphertext);

    System.out.println(new String(decryptedText, "UTF8"));
  }
}
//-126 -104 127 -75 -34 -71 -94 -96 java2s