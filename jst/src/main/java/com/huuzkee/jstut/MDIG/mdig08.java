//36.27.8.Digest Input
//http://www.java2s.com/Tutorial/Java/0490__Security/DigestInput.htm

package com.huuzkee.jstut.MDIG;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class mdig08 {
  public static void main(String args[]) throws Exception {
    MessageDigest m = MessageDigest.getInstance("MD5");
    FileInputStream fin = new FileInputStream(args[0]);
    DigestInputStream din = new DigestInputStream(fin, m);
    while (din.read() != -1)
      ;

    byte s[] = m.digest();
    for (int i = 0; i < s.length; i++) {
      System.out.print( Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6));
    }
  }
}