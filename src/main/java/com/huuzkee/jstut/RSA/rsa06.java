//36.38.6.Simple Digital Signature Example
//http://www.java2s.com/Tutorial/Java/0490__Security/SimpleDigitalSignatureExample.htm

package com.huuzkee.jstut.RSA;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import sun.misc.BASE64Encoder;

public class rsa06 {
  public static void main(String[] args) throws Exception {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(1024);
    KeyPair keyPair = kpg.genKeyPair();

    byte[] data = "test".getBytes("UTF8");

    Signature sig = Signature.getInstance("MD5WithRSA");
    sig.initSign(keyPair.getPrivate());
    sig.update(data);
    byte[] signatureBytes = sig.sign();
    System.out.println("Singature:" + new BASE64Encoder().encode(signatureBytes));

    sig.initVerify(keyPair.getPublic());
    sig.update(data);

    System.out.println(sig.verify(signatureBytes));
  }
}