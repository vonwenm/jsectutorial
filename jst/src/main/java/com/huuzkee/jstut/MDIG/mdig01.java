//36.27.1.Message Digest Demo
//http://www.java2s.com/Tutorial/Java/0490__Security/MessageDigestDemo.htm

package com.huuzkee.jstut.MDIG;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class mdig01 {
  private static int BUFFER_SIZE = 32 * 1024;

  public static void main(String[] args) throws Exception {
    System.out.println("test.txt: " + md("text.txt"));
  }

  public static String md(String f) throws Exception {
    BufferedInputStream file = new BufferedInputStream(new FileInputStream(f));
    MessageDigest md = MessageDigest.getInstance("MD5");
    DigestInputStream in = new DigestInputStream(file, md);
    int i;
    byte[] buffer = new byte[BUFFER_SIZE];
    do {
      i = in.read(buffer, 0, BUFFER_SIZE);
    } while (i == BUFFER_SIZE);
    md = in.getMessageDigest();
    in.close();

    return new String(md.digest());
  }
}