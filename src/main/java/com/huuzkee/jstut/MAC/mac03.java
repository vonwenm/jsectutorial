//36.25.3.Generating a Message Authentication Code (MAC) Key
//http://www.java2s.com/Tutorial/Java/0490__Security/GeneratingaMessageAuthenticationCodeMACKey.htm

package com.huuzkee.jstut.MAC;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class mac03 {
  public static void main(String[] argv) throws Exception {

    KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
    SecretKey key = keyGen.generateKey();

    // Generate a key for the HMAC-SHA1 keyed-hashing algorithm
    keyGen = KeyGenerator.getInstance("HmacSHA1");
    key = keyGen.generateKey();
  }
}