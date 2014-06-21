//36.13.1.using the name DESede rather than TripleDES
//http://www.java2s.com/Tutorial/Java/0490__Security/usingthenameDESederatherthanTripleDES.htm

package com.huuzkee.jstut.DSED;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class dsed01 {
  public static void main(String[] args) throws Exception {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
    keyGenerator.init(168);
    Key key = keyGenerator.generateKey();

    Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] ciphertext = cipher.doFinal("text".getBytes("UTF8"));

    for (int i = 0; i < ciphertext.length; i++) {
      System.out.print(ciphertext[i] + " ");
    }

    cipher.init(Cipher.DECRYPT_MODE, key);

    byte[] decryptedText = cipher.doFinal(ciphertext);

    System.out.println(new String(decryptedText, "UTF8"));
  }
}
//-71 -27 -10 -67 -24 -37 -79 70 text