//36.15.3.Using DigestInputStream
//http://www.java2s.com/Tutorial/Java/0490__Security/UsingDigestInputStream.htm

package com.huuzkee.jstut.DIGS;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class digs03 {
  public static void main(String args[]) throws Exception {
    FileInputStream fis = new FileInputStream("testfile.txt");
    MessageDigest md = MessageDigest.getInstance("SHA");
    DigestInputStream dis = new DigestInputStream(fis, md);
    ObjectInputStream ois = new ObjectInputStream(dis);
    Object o = ois.readObject();
    if (!(o instanceof String)) {
      System.out.println("Unexpected data in file");
      System.exit(-1);
    }
    String data = (String) o;
    System.out.println("Got message " + data);
    dis.on(false);
    o = ois.readObject();
    if (!(o instanceof byte[])) {
      System.out.println("Unexpected data in file");
      System.exit(-1);
    }
    byte origDigest[] = (byte[]) o;
    System.out.println(MessageDigest.isEqual(md.digest(), origDigest));
  }
}