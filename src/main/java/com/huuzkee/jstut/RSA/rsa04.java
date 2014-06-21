//36.38.4.RSA example with OAEP Padding and random key generation.
//http://www.java2s.com/Tutorial/Java/0490__Security/RSAexamplewithOAEPPaddingandrandomkeygeneration.htm

package com.huuzkee.jstut.RSA;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

public class rsa04 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    byte[] input = "abc".getBytes();
    Cipher cipher = Cipher.getInstance("RSA/None/OAEPWithSHA1AndMGF1Padding", "BC");
    SecureRandom random = new SecureRandom();
    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");

    generator.initialize(386, random);

    KeyPair pair = generator.generateKeyPair();
    Key pubKey = pair.getPublic();

    Key privKey = pair.getPrivate();

    cipher.init(Cipher.ENCRYPT_MODE, pubKey, random);
    byte[] cipherText = cipher.doFinal(input);
    System.out.println("cipher: " + new String(cipherText));

    cipher.init(Cipher.DECRYPT_MODE, privKey);
    byte[] plainText = cipher.doFinal(cipherText);
    System.out.println("plain : " + new String(plainText));
  }
}