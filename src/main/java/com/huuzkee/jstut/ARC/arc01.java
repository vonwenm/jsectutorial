//36.3.1.Basic stream cipher example
//http://www.java2s.com/Tutorial/Java/0490__Security/Basicstreamcipherexample.htm

package com.huuzkee.jstut.ARC;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class arc01 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    byte[] input = "input".getBytes();
    byte[] keyBytes = "input123".getBytes();

    SecretKeySpec key = new SecretKeySpec(keyBytes, "ARC4");

    Cipher cipher = Cipher.getInstance("ARC4", "BC");

    byte[] cipherText = new byte[input.length];

    cipher.init(Cipher.ENCRYPT_MODE, key);

    int ctLength = cipher.update(input, 0, input.length, cipherText, 0);

    ctLength += cipher.doFinal(cipherText, ctLength);

    System.out.println("cipher text: " + new String(cipherText));

    byte[] plainText = new byte[ctLength];

    cipher.init(Cipher.DECRYPT_MODE, key);

    int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);

    ptLength += cipher.doFinal(plainText, ptLength);

    System.out.println("plain text : " + new String(plainText));
  }
}