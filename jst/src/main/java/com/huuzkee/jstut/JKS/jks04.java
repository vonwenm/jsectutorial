//36.19.4.JKS keystore: get certificate chain
//http://www.java2s.com/Tutorial/Java/0490__Security/JKSkeystoregetcertificatechain.htm

package com.huuzkee.jstut.JKS;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;

public class jks04{

  public static void main(String args[]) throws Exception {
    String storename = args[0];
    char[] storepass = args[1].toCharArray();
    String alias = args[2];
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(new FileInputStream(storename), storepass);
    java.security.cert.Certificate[] cchain = ks.getCertificateChain(alias);
    List mylist = new ArrayList();
    for (int i = 0; i < cchain.length; i++) {
      mylist.add(cchain[i]);
    }
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    CertPath cp = cf.generateCertPath(mylist);
    System.out.println(cp);
  }
}