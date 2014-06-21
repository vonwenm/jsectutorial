//36.27.5.Masher a file
//http://www.java2s.com/Tutorial/Java/0490__Security/Masherafile.htm

package com.huuzkee.jstut.MDIG;

import java.io.FileInputStream;
import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class mdig05 {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: Masher filename");
      return;
    }
    MessageDigest md = MessageDigest.getInstance("MD5");
    FileInputStream in = new FileInputStream(args[0]);
    byte[] buffer = new byte[8192];
    int length;
    while ((length = in.read(buffer)) != -1)
      md.update(buffer, 0, length);
    byte[] raw = md.digest();
    BASE64Encoder encoder = new BASE64Encoder();
    String base64 = encoder.encode(raw);
    System.out.println(base64);
  }
}