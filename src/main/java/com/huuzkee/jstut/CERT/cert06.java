//36.7.6.Store Certificate
//http://www.java2s.com/Tutorial/Java/0490__Security/StoreCertificate.htm

package com.huuzkee.jstut.CERT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.KeyStore;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.List;

public class cert06 {
  public static void main(String args[]) throws Exception {
    FileInputStream f = new FileInputStream("CertPath.dat");
    ObjectInputStream b = new ObjectInputStream(f);
    CertPath cp = (CertPath) b.readObject();

    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(null, null);
    List cplist = cp.getCertificates();
    Object[] o = cplist.toArray();
    for (int i = 0; i < o.length; i++) {
      X509Certificate c = (X509Certificate) o[i];
      ks.setCertificateEntry("my" + i, c);
    }
    FileOutputStream output = new FileOutputStream("MyCertPathStore");
    ks.store(output, "mypass".toCharArray());
    output.close();

  }
}