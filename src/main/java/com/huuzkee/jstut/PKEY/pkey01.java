//36.35.1.Certificate and PublicKey
//http://www.java2s.com/Tutorial/Java/0490__Security/CertificateandPublicKey.htm

package com.huuzkee.jstut.PKEY;

import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class pkey01 {
  public static void main(String args[]) throws Exception {

    Certificate[] certpath = new Certificate[args.length - 1];
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    int i;
    for (i = 0; i < args.length - 1; i++) {
      FileInputStream in = new FileInputStream(args[i]);
      certpath[i] = cf.generateCertificate(in);
    }
    FileInputStream in = new FileInputStream(args[i]);
    Certificate trust = cf.generateCertificate(in);

    boolean pass = false;
    String reason = "";
    for (i = 0; i < certpath.length; i++) {
      try {
        PublicKey pbk;
        if (i == certpath.length - 1) {
          pbk = trust.getPublicKey();
        } else {
          pbk = certpath[i + 1].getPublicKey();
        }
        certpath[i].verify(pbk);
        pass = true;
      } catch (Exception e) {
        pass = false;
        reason += i + "  " + e.toString();
        break;
      }
    }
    System.out.println(pass);
  }
}