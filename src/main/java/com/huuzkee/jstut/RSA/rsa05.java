//36.38.5.An example of using RSA to encrypt a single asymmetric key
//http://www.java2s.com/Tutorial/Java/0490__Security/AnexampleofusingRSAtoencryptasingleasymmetrickey.htm

package com.huuzkee.jstut.RSA;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class rsa05 {
  public static void main(String[] args) throws Exception {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
    keyGenerator.init(128);
    Key blowfishKey = keyGenerator.generateKey();

    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(1024);
    KeyPair keyPair = keyPairGenerator.genKeyPair();

    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

    byte[] blowfishKeyBytes = blowfishKey.getEncoded();
    System.out.println(new String(blowfishKeyBytes));
    byte[] cipherText = cipher.doFinal(blowfishKeyBytes);
    System.out.println(new String(cipherText));
    cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

    byte[] decryptedKeyBytes = cipher.doFinal(cipherText);
    System.out.println(new String(decryptedKeyBytes));
    SecretKey newBlowfishKey = new SecretKeySpec(decryptedKeyBytes, "Blowfish");
  }
}