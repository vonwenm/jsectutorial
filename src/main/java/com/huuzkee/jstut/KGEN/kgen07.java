//36.21.7.Get the formats of the encoded bytes
//http://www.java2s.com/Tutorial/Java/0490__Security/Gettheformatsoftheencodedbytes.htm

package com.huuzkee.jstut.KGEN;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class kgen07 {
  public static void main (String[] argv) throws Exception {
    String algorithm = "DSA"; // or RSA, DH, etc.

    // Generate a 1024-bit Digital Signature Algorithm (DSA) key pair
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
    keyGen.initialize(1024);
    KeyPair keypair = keyGen.genKeyPair();
    PrivateKey privateKey = keypair.getPrivate();
    PublicKey publicKey = keypair.getPublic();
    String format = privateKey.getFormat(); // PKCS#8
    format = publicKey.getFormat(); // X.509
  }
}