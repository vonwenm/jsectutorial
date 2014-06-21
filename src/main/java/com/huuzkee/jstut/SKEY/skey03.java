//36.39.3.Create SecretKey
//http://www.java2s.com/Tutorial/Java/0490__Security/CreateSecretKey.htm

package com.huuzkee.jstut.SKEY;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class skey03 {
  public static void main(String[] args) throws Exception {
    KeyGenerator kg = KeyGenerator.getInstance("DESede");
    Key sharedKey = kg.generateKey();

    String password = "password";
    byte[] salt = "salt1234".getBytes();
    PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 20);
    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
    SecretKeyFactory kf = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
    SecretKey passwordKey = kf.generateSecret(keySpec);
    Cipher c = Cipher.getInstance("PBEWithMD5AndDES");
    c.init(Cipher.WRAP_MODE, passwordKey, paramSpec);
    byte[] wrappedKey = c.wrap(sharedKey);

    c = Cipher.getInstance("DESede");
    c.init(Cipher.ENCRYPT_MODE, sharedKey);
    byte[] input = "input".getBytes();
    byte[] encrypted = c.doFinal(input);

    c = Cipher.getInstance("PBEWithMD5AndDES");

    c.init(Cipher.UNWRAP_MODE, passwordKey, paramSpec);
    Key unwrappedKey = c.unwrap(wrappedKey, "DESede", Cipher.SECRET_KEY);

    c = Cipher.getInstance("DESede");
    c.init(Cipher.DECRYPT_MODE, unwrappedKey);
    System.out.println(new String(c.doFinal(encrypted)));
  }
}