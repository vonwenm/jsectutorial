//36.27.2.Digest Stream
//http://www.java2s.com/Tutorial/Java/0490__Security/DigestStream.htm

package com.huuzkee.jstut.MDIG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;

public class mdig02 {
  public static void main(String[] args) throws Exception{
    performOutputTest();
    performInputTest();
  }

  static void performOutputTest() throws Exception {
      MessageDigest md = MessageDigest.getInstance("SHA");
      FileOutputStream fout = new FileOutputStream("sha-results.txt");
      DigestOutputStream out = new DigestOutputStream(fout, md);
      byte[] b = "testCase".getBytes();
      out.write(b, 0, b.length);
      md = out.getMessageDigest();
      String s = new String(md.digest());
      System.out.println("Calculated result: " + s);
  }

  static void performInputTest()  throws Exception{
      MessageDigest md = MessageDigest.getInstance("SHA");
      FileInputStream fin = new FileInputStream("sha-results.txt");
      DigestInputStream in = new DigestInputStream(fin, md);
      byte[] b = new byte["testCase".getBytes().length];
      in.read(b, 0, "testCase".getBytes().length);
      md = in.getMessageDigest();
      String s = new String(md.digest());
      System.out.println("Calculated result:  " + s);
  }
}