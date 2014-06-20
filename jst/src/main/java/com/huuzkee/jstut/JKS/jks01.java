//36.19.1.Use JKS
//http://www.java2s.com/Tutorial/Java/0490__Security/UseJKS.htm

package com.huuzkee.jstut.JKS;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class jks01 {

  public static void main(String args[]) throws Exception {
    String pass = "wshr.ut";
    String alias = "mytest";
    String name = "mykeystore";

    FileInputStream in = new FileInputStream(name);
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(in, pass.toCharArray());

    Certificate c = ks.getCertificate(alias);
    in.close();
    System.out.println(c);

  }
}