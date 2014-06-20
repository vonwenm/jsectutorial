//36.25.1.Mac creation
//http://www.java2s.com/Tutorial/Java/0490__Security/Maccreation.htm

package com.huuzkee.jstut.MAC;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class mac01 {
  public static void main(String args[]) throws Exception {
    SecretKeySpec k = new SecretKeySpec("1234".getBytes(), "HMACSHA1");
    Mac m = Mac.getInstance("HmacMD5");
    m.init(k);
    m.update("test".getBytes("UTF8"));
    byte s[] = m.doFinal();
    for (int i = 0; i < s.length; i++) {
      System.out.print( Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6));
    }
  }
}