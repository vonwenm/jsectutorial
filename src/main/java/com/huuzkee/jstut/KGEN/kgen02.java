//36.21.2.Generating a Symmetric Key
//http://www.java2s.com/Tutorial/Java/0490__Security/GeneratingaSymmetricKey.htm

package com.huuzkee.jstut.KGEN;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class kgen02 {
  public static void main(String[] argv) throws Exception {
    // Generate a DES key
    KeyGenerator keyGen = KeyGenerator.getInstance("DES");
    SecretKey key = keyGen.generateKey();

    // Generate a Blowfish key
    keyGen = KeyGenerator.getInstance("Blowfish");
    key = keyGen.generateKey();

    // Generate a triple DES key
    keyGen = KeyGenerator.getInstance("DESede");
    key = keyGen.generateKey();
  }
}