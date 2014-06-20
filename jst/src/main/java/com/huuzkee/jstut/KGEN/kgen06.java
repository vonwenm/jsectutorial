//36.21.6.Get the bytes of the public and private keys
//http://www.java2s.com/Tutorial/Java/0490__Security/Getthebytesofthepublicandprivatekeys.htm

package com.huuzkee.jstut.KGEN;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class kgen06 {
  public static void main(String[] argv) throws Exception {
    String algorithm = "DSA"; // or RSA, DH, etc.

    // Generate a 1024-bit Digital Signature Algorithm (DSA) key pair
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
    keyGen.initialize(1024);
    KeyPair keypair = keyGen.genKeyPair();
    PrivateKey privateKey = keypair.getPrivate();
    PublicKey publicKey = keypair.getPublic();

    byte[] privateKeyBytes = privateKey.getEncoded();
    byte[] publicKeyBytes = publicKey.getEncoded();
  }
}