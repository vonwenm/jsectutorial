//36.15.1.Create a checksum
//http://www.java2s.com/Tutorial/Java/0490__Security/Createachecksum.htm

package com.huuzkee.jstut.DIGS;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class digs01 {
  public static void main(String args[]) throws Exception {
    InputStream fis = new FileInputStream("a.exe");

    byte[] buffer = new byte[1024];
    MessageDigest complete = MessageDigest.getInstance("MD5");
    int numRead;
    do {
      numRead = fis.read(buffer);
      if (numRead > 0) {
        complete.update(buffer, 0, numRead);
      }
    } while (numRead != -1);
    fis.close();

    byte[] b = complete.digest();
    String result = "";
    for (int i = 0; i < b.length; i++) {
      result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
    }
    System.out.println(result);

  }
}