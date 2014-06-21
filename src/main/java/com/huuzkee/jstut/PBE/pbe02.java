//36.28.2.PBE With SHA And Two fish
//http://www.java2s.com/Tutorial/Java/0490__Security/PBEWithSHAAndTwofish.htm

package com.huuzkee.jstut.PBE;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Decoder;

public class pbe02 {

  public static void main(String[] args) throws Exception {
    System.out.println(decrypt(new char[] { 'a', 'b', 'c', 'd' }, "plaintext1234567890"));
  }

  private static String decrypt(char[] password, String text) throws Exception {
    String salt = text.substring(0, 12);
    String ciphertext = text.substring(12, text.length());
    BASE64Decoder decoder = new BASE64Decoder();
    byte[] saltArray = decoder.decodeBuffer(salt);
    byte[] ciphertextArray = decoder.decodeBuffer(ciphertext);

    PBEKeySpec keySpec = new PBEKeySpec(password);

    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithSHAAndTwofish-CBC");

    SecretKey key = keyFactory.generateSecret(keySpec);

    PBEParameterSpec paramSpec = new PBEParameterSpec(saltArray, 1000);

    Cipher cipher = Cipher.getInstance("PBEWithSHAAndTwofish-CBC");
    cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

    return new String(cipher.doFinal(ciphertextArray));
  }
}