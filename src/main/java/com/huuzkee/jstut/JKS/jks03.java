//36.19.3.JKS: List aliases
//http://www.java2s.com/Tutorial/Java/0490__Security/JKSListaliases.htm

package com.huuzkee.jstut.JKS;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Enumeration;

public class jks03 {
  public static void main(String args[]) throws Exception {
    String pass = "wshr.ut";
    String name = "mykeystore";
    FileInputStream in = new FileInputStream(name);
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(in, pass.toCharArray());
    Enumeration e = ks.aliases();
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }

  }
}