//36.16.1.Use DSA to Sign
//http://www.java2s.com/Tutorial/Java/0490__Security/UseDSAtoSign.htm

package com.huuzkee.jstut.DSA;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class dsa01 {
  public static void main(String[] args) throws Exception {
    String alg = "DSA";
    KeyPairGenerator kg = KeyPairGenerator.getInstance(alg);
    KeyPair keyPair = kg.genKeyPair();

    byte[] signature = performSigning("test", alg, keyPair);
    performVerification(args[0], alg, signature, keyPair.getPublic());
  }

  static byte[] performSigning(String s, String alg, KeyPair keyPair) throws Exception {
    Signature sign = Signature.getInstance(alg);
    PrivateKey privateKey = keyPair.getPrivate();
    PublicKey publicKey = keyPair.getPublic();
    sign.initSign(privateKey);
    sign.update(s.getBytes());
    return sign.sign();
  }

  static void performVerification(String s, String alg, byte[] signature, PublicKey publicKey)
      throws Exception {
    Signature sign = Signature.getInstance(alg);
    sign.initVerify(publicKey);
    sign.update(s.getBytes());
    System.out.println(sign.verify(signature));
  }
}