//36.22.7.Generating a Public/Private Key Pair
//http://www.java2s.com/Tutorial/Java/0490__Security/GeneratingaPublicPrivateKeyPair.htm

package com.huuzkee.jstut.KPG;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class kpg07 {
  public static void main(String[] argv) throws Exception {
    // Generate a 1024-bit Digital Signature Algorithm (DSA) key pair
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
    keyGen.initialize(1024);
    KeyPair keypair = keyGen.genKeyPair();
    PrivateKey privateKey = keypair.getPrivate();
    System.out.println(privateKey);
    PublicKey publicKey = keypair.getPublic();
    System.out.println(publicKey);
  }
}