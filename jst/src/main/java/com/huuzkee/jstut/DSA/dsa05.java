//36.16.5.Digital Signature Algorithm Demo
//http://www.java2s.com/Tutorial/Java/0490__Security/DigitalSignatureAlgorithmDemo.htm

package com.huuzkee.jstut.DSA;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

public class dsa05 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "BC");

    keyGen.initialize(512, new SecureRandom());

    KeyPair keyPair = keyGen.generateKeyPair();
    Signature signature = Signature.getInstance("DSA", "BC");

    signature.initSign(keyPair.getPrivate(), new SecureRandom());
    byte[] message = "abc".getBytes();
    signature.update(message);

    byte[] sigBytes = signature.sign();
    signature.initVerify(keyPair.getPublic());
    signature.update(message);
    System.out.println(signature.verify(sigBytes));
  }
}