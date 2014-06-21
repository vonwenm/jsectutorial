//36.25.2.Use MAC
//http://www.java2s.com/Tutorial/Java/0490__Security/UseMAC.htm

package com.huuzkee.jstut.MAC;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class mac02 {
  public static void main(String[] args) throws Exception {
    String alg = "HmacMD5";
    Mac mac = Mac.getInstance(alg);
    KeyGenerator kg = KeyGenerator.getInstance(alg);
    SecretKey key = kg.generateKey();
    mac.init(key);
    mac.update("test".getBytes());
    byte[] b = mac.doFinal();
    System.out.println(new String(b));

  }
}