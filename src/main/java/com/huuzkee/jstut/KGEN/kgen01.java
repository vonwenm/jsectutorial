//36.21.1.Key Generator Demo
//http://www.java2s.com/Tutorial/Java/0490__Security/KeyGeneratorDemo.htm

package com.huuzkee.jstut.KGEN;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class kgen01 {
  public static void main(String[] args) {
    if (args.length != 2) {
      String err = "Usage: KeyGeneratorApp algorithmName keySize";
      System.out.println(err);
      System.exit(0);
    }
    int keySize = (new Integer(args[1])).intValue();
    SecretKey skey = null;
    KeyPair keys = null;
    String algorithm = args[0];

    try {
      KeyPairGenerator kpg = KeyPairGenerator.getInstance(algorithm);
      kpg.initialize(keySize);
      keys = kpg.genKeyPair();
    } catch (NoSuchAlgorithmException ex1) {
      try {
        KeyGenerator kg = KeyGenerator.getInstance(algorithm);
        kg.init(keySize);
        skey = kg.generateKey();
      } catch (NoSuchAlgorithmException ex2) {
        System.out.println("Algorithm not supported: " + algorithm);
        System.exit(0);

      }
    }
  }
}