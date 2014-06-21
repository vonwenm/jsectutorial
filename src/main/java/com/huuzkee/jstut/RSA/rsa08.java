//36.38.8.RSA Signature Generation
//http://www.java2s.com/Tutorial/Java/0490__Security/RSASignatureGeneration.htm

package com.huuzkee.jstut.RSA;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

public class rsa08 {
  public static void main(String[] args) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");

    keyGen.initialize(512, new SecureRandom());

    KeyPair keyPair = keyGen.generateKeyPair();
    Signature signature = Signature.getInstance("SHA1withRSA", "BC");

    signature.initSign(keyPair.getPrivate(), new SecureRandom());

    byte[] message = "abc".getBytes();
    signature.update(message);

    byte[] sigBytes = signature.sign();
    signature.initVerify(keyPair.getPublic());
    signature.update(message);
    System.out.println(signature.verify(sigBytes));
  }
}