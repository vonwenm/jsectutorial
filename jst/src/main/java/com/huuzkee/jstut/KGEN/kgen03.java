//36.21.3.Getting the Bytes of a Generated Symmetric Key
//http://www.java2s.com/Tutorial/Java/0490__Security/GettingtheBytesofaGeneratedSymmetricKey.htm

package com.huuzkee.jstut.KGEN;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class kgen03 {
  public static void main(String[] argv) throws Exception {
    // Generate a key
    KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
    SecretKey key = keyGen.generateKey();

    // Get the bytes of the key
    byte[] keyBytes = key.getEncoded();
    int numBytes = keyBytes.length;

    // The bytes can be converted back to a SecretKey
    SecretKey key2 = new SecretKeySpec(keyBytes, "DESede");
    boolean b = key.equals(key2); // true
  }
}