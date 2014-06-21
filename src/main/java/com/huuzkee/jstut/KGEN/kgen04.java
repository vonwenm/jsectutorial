//36.21.4.Generate a key for the HMAC-SHA1 keyed-hashing algorithm
//http://www.java2s.com/Tutorial/Java/0490__Security/GenerateakeyfortheHMACSHA1keyedhashingalgorithm.htm

package com.huuzkee.jstut.KGEN;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class kgen04 {
  public static void main(String[] argv) throws Exception {

    KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
    SecretKey key = keyGen.generateKey();

    // Generate a key for the HMAC-SHA1 keyed-hashing algorithm
    keyGen = KeyGenerator.getInstance("HmacSHA1");
    key = keyGen.generateKey();
  }
}