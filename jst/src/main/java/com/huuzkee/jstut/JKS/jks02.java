//36.19.2.Use JKS KeyStore to load key
//http://www.java2s.com/Tutorial/Java/0490__Security/UseJKSKeyStoretoloadkey.htm

package com.huuzkee.jstut.JKS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;

public class jks02 {
  public static void main(String args[]) throws Exception {
    char[] oldpass = args[0].toCharArray();
    char[] newpass = args[1].toCharArray();
    String name = "mykeystore";
    FileInputStream in = new FileInputStream(name);
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(in, oldpass);
    in.close();
    FileOutputStream output = new FileOutputStream(name);
    ks.store(output, newpass);
    output.close();
  }
}