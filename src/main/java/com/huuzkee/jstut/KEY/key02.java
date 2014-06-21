//36.20.2.PBE key spec
//http://www.java2s.com/Tutorial/Java/0490__Security/PBEkeyspec.htm

package com.huuzkee.jstut.KEY;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class key02 {

  public static void main(String[] args) throws Exception {
    PBEKeySpec keySpec = new PBEKeySpec("charArray".toCharArray());
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
    SecretKey key = keyFactory.generateSecret(keySpec);
    System.out.println(new String(key.getEncoded()));
  }
}