//36.27.7.MD5 MessageDigest
//http://www.java2s.com/Tutorial/Java/0490__Security/MD5MessageDigest.htm

package com.huuzkee.jstut.MDIG;

import java.security.MessageDigest;

public class mdig07 {
  public static void main(String args[]) throws Exception {
    MessageDigest m = MessageDigest.getInstance("MD5");
    m.update("test".getBytes());
    byte s[] = m.digest();
    String result = "";
    for (int i = 0; i < s.length; i++) {
      result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
    }
    System.out.println(result);
  }
}
//098f6bcd4621d373cade4e832627b4f6