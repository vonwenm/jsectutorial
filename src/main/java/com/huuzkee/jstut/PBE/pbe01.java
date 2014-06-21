//36.28.1.Read the first 8 bytes of the ciphertext and use that as the salt
//http://www.java2s.com/Tutorial/Java/0490__Security/Readthefirst8bytesoftheciphertextandusethatasthesalt.htm

package com.huuzkee.jstut.PBE;

import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Encoder;

public class pbe01 {

  public static void main(String[] args) throws Exception {
   System.out.println(encrypt(new char[] { 'a', 'b', 'c', 'd' }, "plaintext1234567890"));
  }

  private static String encrypt(char[] password, String plaintext) throws Exception {

    byte[] salt = new byte[8];
    Random random = new Random();
    random.nextBytes(salt);

    PBEKeySpec keySpec = new PBEKeySpec(password);

    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithSHAAndTwofish-CBC");

    SecretKey key = keyFactory.generateSecret(keySpec);

    PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 1000);

    Cipher cipher = Cipher.getInstance("PBEWithSHAAndTwofish-CBC");
    cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

    byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

    BASE64Encoder encoder = new BASE64Encoder();

    String saltString = encoder.encode(salt);
    String ciphertextString = encoder.encode(ciphertext);

    return saltString + ciphertextString;
  }


}